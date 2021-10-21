package com.coder.dao;





import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.BookGroup;
import com.coder.model.Major;
import com.coder.model.Shell;
import com.coder.model.Type;





@Repository("majorDoa")
public class MajorDao extends AbstractDao<Integer,Major>{
	
	public Integer saveMajor(Major major)
	{
	return (Integer)super.persist(major);

		}
	public Major getMajorById(int id){
		Major major=super.criteriaQuerryGetObjectById(id,"majorId");
		return major;
		}
  
public void  updateMajor(Major major)
{
super.update(major);

}

public List<Major> getMajors() {
	List<Major> majors=(List<Major>)super.getAllEntity();
		return majors;
	}

}
