package com.coder.dao;





import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coder.model.Book;
import com.coder.model.BookGroup;

import com.coder.model.Type;
@Repository("typeDoa")
public class TypeDao extends AbstractDao<Integer,Type>{
	
	public Integer saveType(Type type)
	  {
	  return (Integer)super.persist(type);
      }
	
	public Type getTypeById(int id){
		Type type=super.criteriaQuerryGetObjectById(id,"typeId");
		return type;
		}
	
	
	public List<Type> getTypesByGroupIdCriteria(int id,String strId){
		SessionFactory sf=super.sessionFactory;
		Session s=sf.openSession();
		CriteriaBuilder builder=s.getCriteriaBuilder();
		CriteriaQuery<Type> cq=builder.createQuery(Type.class);
		Root<Type> rootLang=cq.from(Type.class);			
		cq.select(rootLang);
		cq.where(builder.equal(rootLang.get("bookGroup").get("bookGroupId"),id));
		Query<Type> q=s.createQuery(cq);
		List<Type> list=q.getResultList();
		s.close();
		if(list.size()==0){
		return null;
		}else{
		return list;
		}
	
	}
 
  
public void  updateType(Type type)
{
super.update(type);

}
public List<Type> getTypes() {
	List<Type> bookTypes=(List<Type>)super.getAllEntity();
		return bookTypes;
	}


}
