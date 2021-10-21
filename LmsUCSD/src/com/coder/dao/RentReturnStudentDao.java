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
import com.coder.model.Student;
import com.coder.model.Teacher;
import com.coder.util.DateFormat;
@Repository("rentReturnStudentDao")
public class RentReturnStudentDao extends AbstractDao<Integer,RentReturnStudent>{
	private  Class<RentReturnStudent> persistentClass;
	public Integer saveRentReturnStudent(RentReturnStudent rentReturnStudent)
	{
	return (Integer)super.persist(rentReturnStudent);
    }
	public RentReturnStudent getRentReturnStudentById(int id){
		RentReturnStudent rentReturnStudent=super.criteriaQuerryGetObjectById(id,"stuRentId");
	    return rentReturnStudent;
	}
    public void  updateRentReturnStudent(RentReturnStudent rentReturnStudent)
    {
        super.update(rentReturnStudent);
    }
    public void  deleteRentReturnStudent(RentReturnStudent rentReturnStudent)
    {
        super.delete(rentReturnStudent);
    }
    public List<RentReturnStudent> getRentReturnStudents() {
    	List<RentReturnStudent> rentReturnStudents=(List<RentReturnStudent>)super.getAllEntity();
		return rentReturnStudents;
	}
 
   public List<RentReturnStudent> getRentReturnStuListBySent(){
	   Date date= DateFormat.stringToDateFormat_dd_mm_yyyy("09/09/9999");
    	List<RentReturnStudent> rentReturnStudents=super.criteriaQuerryGetObjectsByTwoPar("notSent", date);
    	System.out.println("rentReturnStudents="+rentReturnStudents.size());
		return rentReturnStudents;
    }
  
}
