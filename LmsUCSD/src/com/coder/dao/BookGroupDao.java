package com.coder.dao;





import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.BookGroup;
import com.coder.model.Shell;
import com.coder.model.Type;





@Repository("bookGroupDoa")
public class BookGroupDao extends AbstractDao<Integer,BookGroup>{
	
	public Integer saveBookGroup(BookGroup bookGroup)
	{
	return (Integer)super.persist(bookGroup);

		}
	public BookGroup getBookGroupById(int id){
		BookGroup bookGroup=super.criteriaQuerryGetObjectById(id,"bookGroupId");
		return bookGroup;
		}
  
public void  updateBookGroup(BookGroup bookGroup)
{
super.update(bookGroup);

}

public List<BookGroup> getBookGroups() {
	List<BookGroup> bookGroups=(List<BookGroup>)super.getAllEntity();
		return bookGroups;
	}

}
