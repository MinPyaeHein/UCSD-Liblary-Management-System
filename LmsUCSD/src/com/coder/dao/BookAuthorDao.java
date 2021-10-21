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
import com.coder.model.BookAuthor;
import com.coder.model.BookGroup;
import com.coder.model.BookType;
import com.coder.model.Type;

@Repository("bookAuthorDao")
public class BookAuthorDao extends AbstractDao<Integer,BookAuthor>{
	
	public Object saveBookAuthor(BookAuthor bookAuthor)
	  {
	  return (Object)super.persistMtoM(bookAuthor);
      }
	
	
	public BookAuthor getBookAuthorById(int id){
		BookAuthor bookAuthor=super.criteriaQuerryGetObjectById(id,"bookAuthorId");
		return bookAuthor;
		}
	public void  updateBookAuthor(BookAuthor bookAuthor)
        {
        super.update(bookAuthor);
        }



}
