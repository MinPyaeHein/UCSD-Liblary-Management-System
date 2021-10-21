package com.coder.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.Admin;
import com.coder.model.Book;
import com.coder.model.BookGroup;
import com.coder.model.Gread;
import com.coder.model.RentReturnStudent;
import com.coder.model.RentReturnTeacher;
import com.coder.model.Student;
import com.coder.model.Teacher;

@Repository("selectQuerryDao")
public class SelectQuerryDao extends AbstractDao<Integer,Admin>{
	
	public  List<Student> getRentBookByGroupId(BookGroup bookGroup){
		Transaction transaction=null;
		 List<Student> students=new ArrayList<Student>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Book> bookRoot = criteriaQuery.from(Book.class);
	         Root<Student> studentRoot = criteriaQuery.from(Student.class);
	         Root<RentReturnStudent> rentReturnStudentRoot = criteriaQuery.from(RentReturnStudent.class);
	         criteriaQuery.multiselect(bookRoot,rentReturnStudentRoot,studentRoot);
	         
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(bookRoot.get("bookGroup"),bookGroup),
	   	    		 builder.equal(rentReturnStudentRoot.get("book"),bookRoot.get("bookId")),
	   	    		 builder.equal(rentReturnStudentRoot.get("student"),studentRoot.get("studentId"))));
	         criteriaQuery.multiselect(studentRoot);
            
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	        // System.out.println("list.size()="+list.size());
	   
	       
	         for (Object object : list) {
	        	
	        	 Student student=(Student)object;
	        //	 System.out.println("StudentId="+student.getStudentId());
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
	public  List<Student> getRentByGread(Gread gread ){
		Transaction transaction=null;
		 List<Student> students=new ArrayList<Student>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<RentReturnStudent> rentReturnStudentRoot= criteriaQuery.from(RentReturnStudent.class);
	         Root<Student> studentRoot = criteriaQuery.from(Student.class);
	      //   Root<Book> bookRoot = criteriaQuery.from(Book.class);
	         criteriaQuery.multiselect(rentReturnStudentRoot,studentRoot);
	         
	   	     criteriaQuery.where(builder.and(
	   	    		
	   	    	//	 builder.equal(rentReturnStudentRoot.get("book"),bookRoot.get("bookId")),
	   	    		 builder.equal(rentReturnStudentRoot.get("student"),studentRoot.get("studentId")),
	   	    		 builder.equal(studentRoot.get("gread"),gread)));
	                 criteriaQuery.multiselect(studentRoot);
	                 
	         //criteriaQuery.distinct(true);
             
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	        //System.out.println("list.size()="+list.size());
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
	public  List<Student> getStudentByGread(Gread gread ){
		Transaction transaction=null;
		 List<Student> students=new ArrayList<Student>();
	      try (Session  session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
             CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Student> studentRoot = criteriaQuery.from(Student.class);
	         Root<Gread> greadRoot = criteriaQuery.from(Gread.class);
	         criteriaQuery.multiselect(studentRoot);
	   	     criteriaQuery.where(
	   	     builder.equal(studentRoot.get("gread"),gread)).distinct(true);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         for (Object object : list) {
	        	 Student student=(Student)object;
	        	 System.out.println("student_id="+student.getStudentId());
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
	public  List<Student> getRentStudentBySex(String sex){
		Transaction transaction=null;
		 List<Student> students=new ArrayList<Student>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Student> studentRoot = criteriaQuery.from(Student.class);
	         Root<RentReturnStudent> rentReturnStudentRoot = criteriaQuery.from(RentReturnStudent.class);
	         criteriaQuery.multiselect(rentReturnStudentRoot,studentRoot);
	   	     criteriaQuery.where(builder.and(
	   	    		 builder.equal(studentRoot.get("gender"),sex),
	   	    		 builder.equal(rentReturnStudentRoot.get("student"),studentRoot.get("studentId"))));
	         criteriaQuery.multiselect(studentRoot);
            
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
	public  List<Book> getBooksByGroup(BookGroup bookGroup){
		Transaction transaction=null;
		 List<Book> books=new ArrayList<Book>();
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Book> bookRoot = criteriaQuery.from(Book.class);
	         criteriaQuery.multiselect(bookRoot);
	   	     criteriaQuery.where(builder.equal(bookRoot.get("bookGroup"),bookGroup));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	         System.out.println("list.size()="+list.size());
	   
	       
	         for (Object object : list) {
	        	
	        	 Book book=(Book)object;
	        
	             books.add(book);
	           
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return books;
	   }
	public int getAllBooksQty(){
		Transaction transaction=null;
		 int size=0;
	      try ( Session    session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	         Root<Book> bookRoot = criteriaQuery.from(Book.class);
	         criteriaQuery.multiselect(bookRoot);
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	          size=list.size();
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	         return 0;
	      }
	      return size;
	   }

public int getAllRentStuQty(){
	Transaction transaction=null;
	 int size=0;
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<RentReturnStudent> rentReturnStudentRoot = criteriaQuery.from(RentReturnStudent.class);
         criteriaQuery.multiselect(rentReturnStudentRoot);
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
          size=list.size();
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
          }
         return 0;
       }
      return size;
   }
public int getAllRentTeaQty(){
	Transaction transaction=null;
	 int size=0;
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<RentReturnTeacher> rentReturnTeacherRoot = criteriaQuery.from(
         RentReturnTeacher.class);
         criteriaQuery.multiselect(rentReturnTeacherRoot);
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         size=list.size();
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
            
         }
         return 0;
      }
      return size;
   }
public int getAllStuQty(){
	Transaction transaction=null;
	 int size=0;
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Student> studentRoot = criteriaQuery.from(
         Student.class);
         criteriaQuery.multiselect(studentRoot);
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         size=list.size();
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
            
         }
         return 0;
      }
      return size;
   }
public int getAllTeaQty(){
	Transaction transaction=null;
	 int size=0;
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<Teacher> teacherRoot = criteriaQuery.from(
         Teacher.class);
         criteriaQuery.multiselect(teacherRoot);
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         size=list.size();
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
            
         }
         return 0;
      }
      return size;
   }
public int getAllBookGroupQty(){
	Transaction transaction=null;
	 int size=0;
      try ( Session    session=sessionFactory.openSession();) {
    	   transaction = session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
         Root<BookGroup> bookGroupRoot = criteriaQuery.from(
        		 BookGroup.class);
         criteriaQuery.multiselect(bookGroupRoot);
         Query<Object[]> query=session.createQuery(criteriaQuery);
         List<Object[]> list=query.getResultList();
         size=list.size();
         transaction.commit();
         session.close();
      } catch (Exception e) {
         e.printStackTrace();
       
         if (transaction != null) {
            transaction.rollback();
            
         }
         return 0;
      }
      return size;
   }

}

