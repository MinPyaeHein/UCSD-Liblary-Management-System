package com.coder.dao;





import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.BookAvailable;
import com.coder.model.BookGroup;
import com.coder.model.Major;
import com.coder.model.Shell;
import com.coder.model.Type;





@Repository("bookAvailableDao")
public class BookAvailableDao extends AbstractDao<Integer,BookAvailable>{
	
	public Integer saveBookAvailable(BookAvailable bookAvailable)
	{
	return (Integer)super.persist(bookAvailable);

		}
	public BookAvailable getBookAvailableByBookId(int id){
		BookAvailable bookAvailable=super.criteriaQuerryGetObjectById(id,"bookId");
		return bookAvailable;
		}
  
public void  updateBookAvailable(BookAvailable bookAvailable)
{
super.update(bookAvailable);

}

public List<BookAvailable> getBookAvailables() {
	List<BookAvailable> bookAvailables=(List<BookAvailable>)super.getAllEntity();
		return bookAvailables;
	}

}
