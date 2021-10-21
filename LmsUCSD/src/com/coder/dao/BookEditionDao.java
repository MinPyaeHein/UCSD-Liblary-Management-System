package com.coder.dao;





import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.BookEdition;
import com.coder.model.BookGroup;
import com.coder.model.Shell;
import com.coder.model.Type;





@Repository("bookEditionDoa")
public class BookEditionDao extends AbstractDao<Integer,BookEdition>{
public Integer saveBookEdition(BookEdition bookEdition)
	{
	return (Integer)super.persist(bookEdition);
    }
public BookEdition getBookEditionById(int id){
	BookEdition bookEdition=super.criteriaQuerryGetObjectById(id,"editionId");
	return bookEdition;
	}
public void  updateBookEdition(BookEdition bookEdition)
    {
    super.update(bookEdition);
    }
public List<BookEdition> getBookEditions() {
	List<BookEdition> bookEditions=(List<BookEdition>)super.getAllEntity();
	return bookEditions;
	}

}
