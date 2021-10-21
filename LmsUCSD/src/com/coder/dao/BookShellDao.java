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
import com.coder.model.BookShell;
import com.coder.model.BookType;
import com.coder.model.Type;







@Repository("bookShellDoa")
public class BookShellDao extends AbstractDao<Integer,BookShell>{
	
	public Object saveBookShell(BookShell bookShell)
	  {
	  return (Object)super.persistMtoM(bookShell);
      }
	
	public BookShell getBookShellById(int id){
		BookShell bookShell=super.criteriaQuerryGetObjectById(id,"bookShellId");
		return bookShell;
		}
	
	public void  updateBookShell(BookShell bookShell)
       {
       super.update(bookShell);
       }



}
