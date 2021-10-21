package com.coder.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.coder.model.Book;
import com.coder.model.Gread;
import com.coder.model.RentReturnStudent;
import com.coder.model.RentReturnTeacher;
import com.coder.model.Student;
import com.coder.model.Teacher;
import com.coder.util.DateFormat;
@Repository("rentReturnTeacherDao")
public class RentReturnTeacherDao extends AbstractDao<Integer,RentReturnTeacher>{
	
	public Integer saveRentReturnTeacher(RentReturnTeacher rentReturnTeacher)
	{
	return (Integer)super.persist(rentReturnTeacher);
    }
	public RentReturnTeacher getRentReturnTeacherById(int id){
		System.out.println("teaRentId="+id);
		RentReturnTeacher rentReturnTeacher=super.criteriaQuerryGetObjectById(id,"teaRentId");
	    return rentReturnTeacher;
	}
    public void  updateRentReturnTeacher(RentReturnTeacher rentReturnTeacher)
    {
        super.update(rentReturnTeacher);
    }
    public void  deleteRentReturnTeacher(RentReturnTeacher rentReturnTeacher)
    {
        super.delete(rentReturnTeacher);
    }
    public List<RentReturnTeacher> getRentReturnTeachers() {
    	List<RentReturnTeacher> rentReturnTeachers=(List<RentReturnTeacher>)super.getAllEntity();
		return rentReturnTeachers;
	}
   public List<RentReturnTeacher> getRentReturnTeacherListBySent(){
	   Date date= DateFormat.stringToDateFormat_dd_mm_yyyy("09/09/9999");
    	List<RentReturnTeacher> rentReturnTeachers=super.criteriaQuerryGetObjectsByTwoPar(1, date);
    	System.out.println("rentReturnTeachers="+rentReturnTeachers.size());
		return rentReturnTeachers;
    }
   public   List<RentReturnTeacher> getRentReturnTeacherBySent(){
		Transaction transaction=null;
		   Date date= DateFormat.stringToDateFormat_dd_mm_yyyy("09/09/9999");
		 List<RentReturnTeacher> rentReturnTeachers=new ArrayList<RentReturnTeacher>();
	      try (Session  session=sessionFactory.openSession();) {
	    	   transaction = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
	        
	         Root<RentReturnTeacher> rentReturnTeacherRoot= criteriaQuery.from(RentReturnTeacher.class);
	     
	         criteriaQuery.multiselect(rentReturnTeacherRoot);
	   	     criteriaQuery.where(
	   	    builder.and(builder.equal(rentReturnTeacherRoot.get("returnDate"),date),builder.equal(rentReturnTeacherRoot.get("sent"),1)));
	         Query<Object[]> query=session.createQuery(criteriaQuery);
	         List<Object[]> list=query.getResultList();
	       
	         for (Object object : list) {
	        	 RentReturnTeacher rentReturnTeacher=(RentReturnTeacher)object;
	        	 rentReturnTeachers.add(rentReturnTeacher);
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
	      return rentReturnTeachers;
	   }
   
}
