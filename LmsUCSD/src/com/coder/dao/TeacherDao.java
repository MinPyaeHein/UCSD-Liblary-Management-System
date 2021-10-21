package com.coder.dao;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.coder.model.Book;
import com.coder.model.Student;
import com.coder.model.Teacher;
@Repository("teacherDao")
public class TeacherDao extends AbstractDao<Integer,Teacher>{
	
	public Integer saveTeacher(Teacher teacher)
	{
	return (Integer)super.persist(teacher);
    }
	public Teacher getTeacherById(int id){
		   Teacher teacher=super.criteriaQuerryGetObjectById(id,"teacherId");
	return teacher;
	}
    public void  updateTeacher(Teacher teacher)
    {
    super.update(teacher);
    }
    public void  deleteTeacher(Teacher teacher)
    {
    super.delete(teacher);
    }
    public List<Teacher> getTeachers() {
	List<Teacher> teachers=(List<Teacher>)super.getAllEntity();
		return teachers;
	}
    public Teacher getLatestTeacherId(){
    	Transaction transaction=null;
    	
    	Teacher teacher=null;
          try ( Session    session=sessionFactory.openSession();) {
        	   transaction = session.beginTransaction();
             CriteriaBuilder builder = session.getCriteriaBuilder();
             CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
             Root<Teacher> teacherRoot = criteriaQuery.from(Teacher.class);
             criteriaQuery.multiselect(teacherRoot);
             criteriaQuery.orderBy(builder.desc(teacherRoot.get("teacherId")));
             Query<Object[]> query=session.createQuery(criteriaQuery);
             query.setMaxResults(1);
             List<Object[]> list=query.getResultList();
             System.out.println("list.size()="+list.size());
             for (Object object : list) {
    	        	
            	  teacher=(Teacher)object;
            	  System.out.println("teacher="+teacher.getTeacherId());
      
               
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
          return teacher;
       }

}
