package com.coder.dao;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.BookAuthor;
import com.coder.model.BookEdition;
import com.coder.model.Gread;
@Repository("bookDoa")
public class BookDao extends AbstractDao<Integer,Book>{
	
	public Integer saveBook(Book book)
	{
	return (Integer)super.persist(book);
   
		}
	public Book getBookById(int id){
		Book book=super.criteriaQuerryGetObjectById(id,"bookId");
		return book;
		}
	public List<Book> getBooks() {
		List<Book> books=(List<Book>)super.getAllEntity();
			return books;
		}
    

   public Boolean deleteBook(Book book){
	  Boolean tf= super.delete(book);
	  return tf;
   }
   public Boolean updateBook(Book book){
	 Boolean tf=super.update(book);
	 return tf;
   }
   
}
