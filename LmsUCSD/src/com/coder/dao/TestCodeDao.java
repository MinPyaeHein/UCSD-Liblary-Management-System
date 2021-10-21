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

import com.coder.model.Admin;
import com.coder.model.Book;
import com.coder.model.Gread;
import com.coder.model.Student;
import com.coder.model.Teacher;
import com.coder.model.TestCode;
@Repository("testCodeDao")
public class TestCodeDao extends AbstractDao<Integer,TestCode>{
	
	public Integer saveTestCode(TestCode testCode)
	{
	return (Integer)super.persist(testCode);
    }
	public TestCode getTestCodeById(int id){
		TestCode admin=super.criteriaQuerryGetObjectById(id,"codeId");
	return admin;
	}
    public void  updateTestCode(TestCode testCode)
    {
    super.update(testCode);
    }
    public void  deleteTestCode(TestCode testCode)
    {
    super.delete(testCode);
    }
    public List<TestCode> getTestCodes() {
	List<TestCode> testCodes=(List<TestCode>)super.getAllEntity();
		return testCodes;
	}
    public  List<TestCode> getTestCodeByNotSent( ){
		Transaction transaction=null;
		 List<TestCode> testCodes=new ArrayList<TestCode>();
	      try (Session  session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	        
	         Root<TestCode> testCodeRoot = criteriaQuery.from(TestCode.class);
	        
	         criteriaQuery.multiselect(testCodeRoot);
	   	     criteriaQuery.where(
	   	     builder.equal(testCodeRoot.get("status"),"notsent"));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	       
	         for (Object object : list) {
	        	 TestCode testCode=(TestCode)object;
	        	 testCodes.add(testCode);
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	            
	         }
	       
	      }
	      return testCodes;
	   }
    public  List<TestCode> getTestCodeByUser( ){
		Transaction transaction=null;
		 List<TestCode> testCodes=new ArrayList<TestCode>();
	      try (Session  session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	        
	         Root<TestCode> testCodeRoot = criteriaQuery.from(TestCode.class);
	        
	         criteriaQuery.multiselect(testCodeRoot);
	   	     criteriaQuery.where(
	   	     builder.equal(testCodeRoot.get("status"),"user"));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	       
	         for (Object object : list) {
	        	 TestCode testCode=(TestCode)object;
	        	 testCodes.add(testCode);
	         }
	         transaction.commit();
	         session.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	       
	         if (transaction != null) {
	            transaction.rollback();
	            
	         }
	       
	      }
	      return testCodes;
	   }
}
