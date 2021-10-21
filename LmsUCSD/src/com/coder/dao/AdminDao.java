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
import com.coder.model.Student;
import com.coder.model.Teacher;
@Repository("adminDao")
public class AdminDao extends AbstractDao<Integer,Admin>{
	
	public Integer saveAdmin(Admin admin)
	{
	return (Integer)super.persist(admin);
    }
	public Admin getTeacherById(int id){
		Admin admin=super.criteriaQuerryGetObjectById(id,"teacherId");
	return admin;
	}
    public void  updateAdmin(Admin admin)
    {
    super.update(admin);
    }
    public void  deleteAdmin(Admin admin)
    {
    super.delete(admin);
    }
    public List<Admin> getAdmins() {
	List<Admin> admins=(List<Admin>)super.getAllEntity();
		return admins;
	} 
    public Admin getLatestAdminId(){
    	Transaction transaction=null;
    	
    	Admin admin=null;
          try ( Session    session=sessionFactory.openSession();) {
        	   transaction = session.beginTransaction();
             CriteriaBuilder builder = session.getCriteriaBuilder();
             CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
             Root<Admin> adminRoot = criteriaQuery.from(Admin.class);
             criteriaQuery.multiselect(adminRoot);
             criteriaQuery.orderBy(builder.desc(adminRoot.get("adminId")));
             Query<Object[]> query=session.createQuery(criteriaQuery);
             query.setMaxResults(1);
             List<Object[]> list=query.getResultList();
             System.out.println("list.size()="+list.size());
             for (Object object : list) {
    	        	
            	 admin=(Admin)object;
            	  System.out.println("teacher="+admin.getAdminId());
      
               
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
          return admin;
       }


}
