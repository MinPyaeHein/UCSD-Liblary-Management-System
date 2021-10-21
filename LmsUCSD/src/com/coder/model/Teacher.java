package com.coder.model;
// Generated Aug 10, 2020 11:24:30 AM by Hibernate Tools 5.0.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Teacher generated by hbm2java
 */
@Entity
@Table(name = "teacher", catalog = "mmhbusin_lmstu")
public class Teacher implements java.io.Serializable {

	private Integer teacherId;
	private AcademicYear academicYear;
	private Department department;
	private Member member;
	private Position position;
	private String teacherName;
	private String email;
	private String phone;
	private String gender;
	private Date createDate;
	private String address;
	private String address1;
	private Set<RentReturnTeacher> rentReturnTeachers = new HashSet<RentReturnTeacher>(0);

	public Teacher() {
	}

	public Teacher(AcademicYear academicYear, Department department, Member member, Position position,
			String teacherName, String email, String phone, String gender, Date createDate, String address) {
		this.academicYear = academicYear;
		this.department = department;
		this.member = member;
		this.position = position;
		this.teacherName = teacherName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.createDate = createDate;
		this.address = address;
	}

	public Teacher(AcademicYear academicYear, Department department, Member member, Position position,
			String teacherName, String email, String phone, String gender, Date createDate, String address,
			String address1, Set<RentReturnTeacher> rentReturnTeachers) {
		this.academicYear = academicYear;
		this.department = department;
		this.member = member;
		this.position = position;
		this.teacherName = teacherName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.createDate = createDate;
		this.address = address;
		this.address1 = address1;
		this.rentReturnTeachers = rentReturnTeachers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "teacher_id", unique = true, nullable = false)
	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "year_id", nullable = false)
	public AcademicYear getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id", nullable = false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "position_id", nullable = false)
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Column(name = "teacher_name", nullable = false, length = 100)
	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false, length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "gender", nullable = false, length = 30)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", nullable = false, length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "address", nullable = false, length = 1000)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "address1", length = 200)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")
	public Set<RentReturnTeacher> getRentReturnTeachers() {
		return this.rentReturnTeachers;
	}

	public void setRentReturnTeachers(Set<RentReturnTeacher> rentReturnTeachers) {
		this.rentReturnTeachers = rentReturnTeachers;
	}

}
