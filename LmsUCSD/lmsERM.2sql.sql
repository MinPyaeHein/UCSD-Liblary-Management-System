SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS rent_return_student;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS rent_return_teacher;
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS academic_year;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book_shell;
DROP TABLE IF EXISTS book_type;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_edition;
DROP TABLE IF EXISTS type;
DROP TABLE IF EXISTS book_group;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS gread;
DROP TABLE IF EXISTS login;
DROP TABLE IF EXISTS major;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS position;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS search;
DROP TABLE IF EXISTS shell;
DROP TABLE IF EXISTS test_code;




/* Create Tables */

CREATE TABLE academic_year
(
	year_id int NOT NULL AUTO_INCREMENT,
	start_year date NOT NULL,
	end_year date NOT NULL,
	PRIMARY KEY (year_id)
);


CREATE TABLE admin
(
	admin_id int NOT NULL AUTO_INCREMENT,
	admin_name varchar(100) CHARACTER SET utf8 NOT NULL,
	email varchar(100) CHARACTER SET utf8 NOT NULL,
	phone varchar(100) CHARACTER SET utf8 NOT NULL,
	address varchar(500) CHARACTER SET utf8 NOT NULL,
	address1 varchar(200),
	nrc varchar(100) CHARACTER SET utf8 NOT NULL,
	role_id int NOT NULL,
	position_id int NOT NULL,
	PRIMARY KEY (admin_id)
) ENGINE = InnoDB;


CREATE TABLE author
(
	author_id int NOT NULL AUTO_INCREMENT,
	author_name varchar(100) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (author_id)
) ENGINE = InnoDB;


CREATE TABLE book
(
	book_id int NOT NULL AUTO_INCREMENT,
	book_name varchar(100) CHARACTER SET utf8 NOT NULL,
	create_date date NOT NULL,
	qty int NOT NULL,
	isbn varchar(100),
	publisher_date date,
	edition_id int NOT NULL,
	book_group_id int NOT NULL,
	PRIMARY KEY (book_id)
) ENGINE = InnoDB;


CREATE TABLE book_author
(
	book_id int NOT NULL,
	author_id int NOT NULL
);


CREATE TABLE book_edition
(
	edition_id int NOT NULL AUTO_INCREMENT,
	edition_name varchar(100) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (edition_id)
) ENGINE = InnoDB;


CREATE TABLE book_group
(
	book_group_id int NOT NULL AUTO_INCREMENT,
	group_name varchar(200) CHARACTER SET utf8 NOT NULL,
	group_code varchar(100) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (book_group_id)
) ENGINE = InnoDB;


CREATE TABLE book_shell
(
	book_id int NOT NULL,
	shell_id int NOT NULL
);


CREATE TABLE book_type
(
	book_id int NOT NULL,
	type_id int NOT NULL
);


CREATE TABLE department
(
	department_id int NOT NULL AUTO_INCREMENT,
	department_name varchar(200) CHARACTER SET utf8 NOT NULL,
	short_term varchar(50) NOT NULL,
	PRIMARY KEY (department_id)
) ENGINE = InnoDB;


CREATE TABLE gread
(
	gread_id int NOT NULL AUTO_INCREMENT,
	gread_name varchar(50) CHARACTER SET utf8 NOT NULL,
	gread_no varchar(30) NOT NULL,
	PRIMARY KEY (gread_id)
) ENGINE = InnoDB;


CREATE TABLE login
(
	user_id varchar(20) CHARACTER SET utf8 NOT NULL,
	user_name varchar(100) CHARACTER SET utf8 NOT NULL,
	password varchar(100) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (user_id)
) ENGINE = InnoDB;


CREATE TABLE major
(
	major_id int NOT NULL AUTO_INCREMENT,
	major_name varchar(100) CHARACTER SET utf8 NOT NULL,
	short_term varchar(50) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (major_id)
) ENGINE = InnoDB;


CREATE TABLE member
(
	member_id int NOT NULL AUTO_INCREMENT,
	member_name varchar(50) NOT NULL,
	coin int NOT NULL,
	PRIMARY KEY (member_id)
);


CREATE TABLE position
(
	position_id int NOT NULL AUTO_INCREMENT,
	position_name varchar(100) CHARACTER SET utf8 NOT NULL,
	short_term varchar(50) NOT NULL,
	PRIMARY KEY (position_id)
) ENGINE = InnoDB;


CREATE TABLE rent_return_student
(
	stu_rent_id int NOT NULL AUTO_INCREMENT,
	rent_date date NOT NULL,
	return_date date,
	due_date date NOT NULL,
	late_feet int,
	sent varchar(20),
	student_id int NOT NULL,
	book_id int NOT NULL,
	admin_id int NOT NULL,
	PRIMARY KEY (stu_rent_id)
);


CREATE TABLE rent_return_teacher
(
	tea_rent_id int NOT NULL AUTO_INCREMENT,
	rent_date date NOT NULL,
	return_date date,
	due_date date NOT NULL,
	late_feet int,
	sent int,
	book_id int NOT NULL,
	teacher_id int NOT NULL,
	admin_id int NOT NULL,
	PRIMARY KEY (tea_rent_id)
) ENGINE = InnoDB;


CREATE TABLE role
(
	role_id int NOT NULL AUTO_INCREMENT,
	role_name varchar(100) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (role_id)
) ENGINE = InnoDB;


CREATE TABLE search
(
	search_id int NOT NULL AUTO_INCREMENT,
	book_id int NOT NULL,
	count int NOT NULL,
	user_id varchar(200) NOT NULL,
	PRIMARY KEY (search_id)
);


CREATE TABLE shell
(
	shell_id int NOT NULL AUTO_INCREMENT,
	shell_no varchar(70) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (shell_id)
) ENGINE = InnoDB;


CREATE TABLE student
(
	student_id int NOT NULL AUTO_INCREMENT,
	roll_number int NOT NULL,
	student_name varchar(100) CHARACTER SET utf8 NOT NULL,
	gender varchar(50) CHARACTER SET utf8 NOT NULL,
	phone varchar(50) NOT NULL,
	create_date date NOT NULL,
	email varchar(100) NOT NULL,
	address varchar(300) CHARACTER SET utf8 NOT NULL,
	address1 varchar(200),
	major_id int NOT NULL,
	gread_id int NOT NULL,
	year_id int NOT NULL,
	member_id int NOT NULL,
	PRIMARY KEY (student_id)
) ENGINE = InnoDB;


CREATE TABLE teacher
(
	teacher_id int NOT NULL AUTO_INCREMENT,
	teacher_name varchar(100) CHARACTER SET utf8 NOT NULL,
	email varchar(100) CHARACTER SET utf8 NOT NULL,
	phone varchar(50) NOT NULL,
	gender varchar(30) CHARACTER SET utf8 NOT NULL,
	create_date date NOT NULL,
	address varchar(1000) CHARACTER SET utf8 NOT NULL,
	address1 varchar(200),
	department_id int NOT NULL,
	position_id int NOT NULL,
	year_id int NOT NULL,
	member_id int NOT NULL,
	PRIMARY KEY (teacher_id)
) ENGINE = InnoDB;


CREATE TABLE test_code
(
	code_id int NOT NULL AUTO_INCREMENT,
	code varchar(30) NOT NULL,
	status varchar(30) NOT NULL,
	mail varchar(50) NOT NULL,
	PRIMARY KEY (code_id)
);


CREATE TABLE type
(
	type_id int NOT NULL AUTO_INCREMENT,
	type_name varchar(100) CHARACTER SET utf8 NOT NULL,
	type_code varchar(100) CHARACTER SET utf8 NOT NULL,
	book_group_id int NOT NULL,
	PRIMARY KEY (type_id)
) ENGINE = InnoDB;



/* Create Foreign Keys */

ALTER TABLE student
	ADD FOREIGN KEY (year_id)
	REFERENCES academic_year (year_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE teacher
	ADD FOREIGN KEY (year_id)
	REFERENCES academic_year (year_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rent_return_student
	ADD FOREIGN KEY (admin_id)
	REFERENCES admin (admin_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rent_return_teacher
	ADD FOREIGN KEY (admin_id)
	REFERENCES admin (admin_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE book_author
	ADD FOREIGN KEY (author_id)
	REFERENCES author (author_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE book_author
	ADD FOREIGN KEY (book_id)
	REFERENCES book (book_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE book_shell
	ADD FOREIGN KEY (book_id)
	REFERENCES book (book_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE book_type
	ADD FOREIGN KEY (book_id)
	REFERENCES book (book_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rent_return_student
	ADD FOREIGN KEY (book_id)
	REFERENCES book (book_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rent_return_teacher
	ADD FOREIGN KEY (book_id)
	REFERENCES book (book_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE book
	ADD FOREIGN KEY (edition_id)
	REFERENCES book_edition (edition_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE book
	ADD FOREIGN KEY (book_group_id)
	REFERENCES book_group (book_group_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE type
	ADD FOREIGN KEY (book_group_id)
	REFERENCES book_group (book_group_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE teacher
	ADD FOREIGN KEY (department_id)
	REFERENCES department (department_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE student
	ADD FOREIGN KEY (gread_id)
	REFERENCES gread (gread_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE student
	ADD FOREIGN KEY (major_id)
	REFERENCES major (major_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE student
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE teacher
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE admin
	ADD FOREIGN KEY (position_id)
	REFERENCES position (position_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE teacher
	ADD FOREIGN KEY (position_id)
	REFERENCES position (position_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE admin
	ADD FOREIGN KEY (role_id)
	REFERENCES role (role_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE book_shell
	ADD FOREIGN KEY (shell_id)
	REFERENCES shell (shell_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rent_return_student
	ADD FOREIGN KEY (student_id)
	REFERENCES student (student_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rent_return_teacher
	ADD FOREIGN KEY (teacher_id)
	REFERENCES teacher (teacher_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE book_type
	ADD FOREIGN KEY (type_id)
	REFERENCES type (type_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



