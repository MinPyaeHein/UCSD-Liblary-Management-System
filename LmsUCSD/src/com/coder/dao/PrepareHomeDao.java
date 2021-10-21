package com.coder.dao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
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

@Repository("prepareHomeDao")
public class PrepareHomeDao extends AbstractDao<Integer,Admin>{
	
	
	
	
	
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

