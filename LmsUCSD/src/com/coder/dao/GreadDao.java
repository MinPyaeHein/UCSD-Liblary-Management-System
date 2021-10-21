package com.coder.dao;





import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.BookGroup;
import com.coder.model.Gread;
import com.coder.model.Shell;
import com.coder.model.Type;





@Repository("GreadDoa")
public class GreadDao extends AbstractDao<Integer,Gread>{
	
	public Integer saveGread(Gread bookGroup)
	{
	return (Integer)super.persist(bookGroup);

		}
	public Gread getGreadById(int id){
		Gread gread=super.criteriaQuerryGetObjectById(id,"greadId");
		return gread;
		}
  
public void  updateGread(Gread gread)
{
super.update(gread);

}

public List<Gread> getGreads() {
	List<Gread> greads=(List<Gread>)super.getAllEntity();
		return greads;
	}

}
