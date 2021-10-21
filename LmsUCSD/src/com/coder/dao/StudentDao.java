package com.coder.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.form.StudentForm;
import com.coder.model.Book;
import com.coder.model.Gread;
import com.coder.model.RentReturnStudent;
import com.coder.model.Student;
import com.coder.model.Teacher;
@Repository("studentDoa")
public class StudentDao extends AbstractDao<Integer,Student>{
	
	public Integer saveStudent(Student student)
	{
	return (Integer)super.persist(student);

		}
	public Student getStudentById(int id){
		Student student=super.criteriaQuerryGetObjectById(id,"studentId");
		return student;
		}
  
public void  updateStudent(Student student)
{
super.update(student);

}

public void  deleteStudent(Student student)
{
super.delete(student);
}
public List<Student> getStudents() {
List<Student> students=(List<Student>)super.getAllEntity();
	return students;
}
public  List<Student> getStudentByEmail(String  email ){
	Transaction transaction=null;
	 List<Student> students=new ArrayList<Student>();
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();

         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        
         Root<Student> studentRoot = criteriaQuery.from(Student.class);
    
         
         criteriaQuery.multiselect(studentRoot);
         
   	     criteriaQuery.where(builder.equal(studentRoot.get("email"),email));
        
         
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
    
         for (Object object : list) {
        	
        	 Student student=(Student)object;
        
        	 students.add(student);
           
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
            
         }
       
      }
      return students;
   }
public  List<Student> testStudentAxist(Student  student ){
	Transaction transaction=null;
	 List<Student> students=new ArrayList<Student>();
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();

         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Student> studentRoot = criteriaQuery.from(Student.class);
         criteriaQuery.multiselect(studentRoot);
  	     criteriaQuery.where(builder.and(
  	    		           
  	    		             builder.equal(studentRoot.get("rollNumber"),student.getRollNumber()),
  	    		             builder.equal(studentRoot.get("academicYear"),student.getAcademicYear()),
  	    		             builder.equal(studentRoot.get("gread"),student.getGread()),
  	    		             builder.equal(studentRoot.get("major"),student.getMajor())
  	    		          
  	    		             ));
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
    
         for (Object object : list) {
        	
        	 Student studentTemp=(Student)object;
        
        	 students.add(studentTemp);
           
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
            
         }
       
      }
      return students;
   }
public Student getLatestStudentId(){
	Transaction transaction=null;
	
	   Student student=null;
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Student> studentRoot = criteriaQuery.from(Student.class);
         criteriaQuery.multiselect(studentRoot);
         criteriaQuery.orderBy(builder.desc(studentRoot.get("studentId")));
         Query<Object[]> query=session.createQuery(criteriaQuery);
         query.setMaxResults(1);
         List<Object[]> list=query.getResultList();
         System.out.println("list.size()="+list.size());
         for (Object object : list) {
	        	
        	  student=(Student)object;
        	  System.out.println("student="+student.getStudentId());
  
           
         }
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
            
         }
         return null;
      }
      return student;
   }

}
