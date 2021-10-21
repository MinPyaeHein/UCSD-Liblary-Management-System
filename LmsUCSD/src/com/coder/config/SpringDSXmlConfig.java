package com.coder.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.coder.model.AcademicYear;
import com.coder.model.Admin;
import com.coder.model.Author;
import com.coder.model.Book;
import com.coder.model.BookAuthor;
import com.coder.model.BookAuthorId;
import com.coder.model.BookEdition;
import com.coder.model.BookGroup;
import com.coder.model.BookShell;
import com.coder.model.BookShellId;
import com.coder.model.BookType;
import com.coder.model.BookTypeId;
import com.coder.model.Department;
import com.coder.model.Gread;
import com.coder.model.Login;
import com.coder.model.Major;
import com.coder.model.Member;
import com.coder.model.Position;
import com.coder.model.RentReturnStudent;
import com.coder.model.RentReturnTeacher;
import com.coder.model.Role;
import com.coder.model.Search;
import com.coder.model.Shell;
import com.coder.model.Student;
import com.coder.model.Teacher;
import com.coder.model.TestCode;
import com.coder.model.Type;




@Configuration//spring.xml
@ComponentScan(basePackages={"com.coder"}) //<context:component-scan
@PropertySources({ //resources/database.properties
		@PropertySource("classpath:application.properties")
})
@EnableTransactionManagement
public class SpringDSXmlConfig {
	@Autowired
	private Environment environment;	
	
	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(
		this.environment.getProperty("jdbc.driverClassName"));
		ds.setUrl(this.environment.getProperty("jdbc.url"));
		ds.setUsername(this.environment.getProperty("jdbc.username"));
		ds.setPassword(this.environment.getProperty("jdbc.password"));
		return ds;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sf){
		HibernateTransactionManager tm=new HibernateTransactionManager(sf);
		return tm;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(){
		LocalSessionFactoryBuilder b=new LocalSessionFactoryBuilder(getDataSource());
		b.addAnnotatedClass(AcademicYear.class);
		b.addAnnotatedClass(Admin.class);
		b.addAnnotatedClass(Author.class);
		b.addAnnotatedClass(Book.class);
		b.addAnnotatedClass(BookAuthor.class);
		b.addAnnotatedClass(BookAuthorId.class);
		b.addAnnotatedClass(BookGroup.class);
		b.addAnnotatedClass(BookType.class);
		b.addAnnotatedClass(BookTypeId.class);
		b.addAnnotatedClass(Department.class);
		b.addAnnotatedClass(Gread.class);
		b.addAnnotatedClass(Login.class);	
		b.addAnnotatedClass(Major.class);
		b.addAnnotatedClass(Position.class);
		b.addAnnotatedClass(RentReturnStudent.class);
		b.addAnnotatedClass(RentReturnTeacher.class);
		b.addAnnotatedClass(Role.class);
		b.addAnnotatedClass(Search.class);
		b.addAnnotatedClass(Shell.class);
		b.addAnnotatedClass(Student.class);
		b.addAnnotatedClass(Teacher.class);
		b.addAnnotatedClass(Type.class);
		b.addAnnotatedClass(BookShell.class);
		b.addAnnotatedClass(BookShellId.class);
		b.addAnnotatedClass(BookEdition.class);
		b.addAnnotatedClass(Member.class);
		b.addAnnotatedClass(TestCode.class);
		
		
		
		return b.buildSessionFactory();
	}
}




