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
import com.coder.model.BookType;
import com.coder.model.Type;







@Repository("bookTypeDoa")
public class BookTypeDao extends AbstractDao<Integer,BookType>{
	
	public Object saveBookType(BookType bookType)
	  {
	  return (Object)super.persistMtoM(bookType);
      }
	
	public BookType getBookTypeById(int id){
		BookType bookType=super.criteriaQuerryGetObjectById(id,"bookTypeId");
		return bookType;
		}
	
	public void  updateBookType(BookType bookType)
       {
       super.update(bookType);
       }



}
