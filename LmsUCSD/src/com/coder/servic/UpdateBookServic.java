package com.coder.servic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AuthorDao;
import com.coder.dao.BookAuthorDao;
import com.coder.dao.BookDao;
import com.coder.dao.BookEditionDao;
import com.coder.dao.BookShellDao;
import com.coder.dao.BookTypeDao;
import com.coder.dao.ShellDao;
import com.coder.dao.TypeDao;
import com.coder.form.AuthorForm;
import com.coder.form.BookForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.SaveBookConfrimForm;
import com.coder.form.ShellForm;
import com.coder.form.TypeForm;
import com.coder.form.UpdateBookForm;
import com.coder.model.Author;
import com.coder.model.Book;
import com.coder.model.BookAuthor;
import com.coder.model.BookAuthorId;
import com.coder.model.BookEdition;
import com.coder.model.BookShell;
import com.coder.model.BookShellId;
import com.coder.model.BookType;
import com.coder.model.BookTypeId;
import com.coder.model.Shell;
import com.coder.model.Type;
import com.coder.util.DateFormat;

@Service
@Repository("updateBookServic")
public class UpdateBookServic {
	@Autowired
	private BookAuthorDao bookAuthorDao;
	@Autowired
	private BookShellDao bookShellDao;
	@Autowired
	private BookTypeDao bookTypeDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookEditionDao bookEditionDao;
	public void prepareUpdateBook(UpdateBookForm updateBookForm){
		if(updateBookForm.getBookId()!=null){
		int bookId=Integer.parseInt(updateBookForm.getBookId());
		Book book=this.bookDao.getBookById(bookId);
		
		ArrayList<BookAuthor> bookAuthors=new ArrayList<>();
		ArrayList<BookShell> bookShells=new ArrayList<>();
		ArrayList<BookType> bookTypes=new ArrayList<>();
		
		BookForm bookForm=new BookForm();
		bookForm.setBookId(book.getBookId()+"");
		bookForm.setBookName(book.getBookName());
		bookForm.setCreateDate(DateFormat.dateToStringFormat_dd_mm_yyyy(book.getCreateDate()));
		bookForm.setIsbn(book.getIsbn());
		bookForm.setPublisherDate(DateFormat.dateToStringFormat_dd_mm_yyyy(book.getPublisherDate()));
		bookForm.setQty(book.getQty()+"");
	
		
		Set<BookAuthor>  setBookAuthors= book.getBookAuthors();
		for(BookAuthor ba:setBookAuthors){
			bookAuthors.add(ba);
		}
		Set<BookShell> setBookShells=book.getBookShells();
		for(BookShell bs:setBookShells){
			bookShells.add(bs);
		}
		Set<BookType> setBookTypes=book.getBookTypes();
		for(BookType bt:setBookTypes){
			bookTypes.add(bt);
		}
		BookEdition bookEdition=book.getBookEdition();
		List<BookEdition> bookEditions=bookEditionDao.getBookEditions();
	    updateBookForm.setSelectBookEdition(bookEdition);
	    updateBookForm.setBookAuthors(bookAuthors);
	    updateBookForm.setBookTypes(bookTypes);
	    updateBookForm.setBookShells(bookShells);
	    updateBookForm.setBookForm(bookForm);
	    updateBookForm.setBookGroup(book.getBookGroup());
		for( BookEdition be:bookEditions){
			if(be.getEditionId()!=bookEdition.getEditionId()){
			updateBookForm.getMapBookEditions().put(""+be.getEditionId(),""+be.getEditionName());
		}
		}
		}
		}
	public void updateBook(UpdateBookForm updateBookForm){
		BookForm bookForm=updateBookForm.getBookForm();
		Book book=this.bookDao.getBookById(Integer.parseInt(bookForm.getBookId()));
		ArrayList<BookAuthor> bookAuthors=updateBookForm.getBookAuthors();
		ArrayList<BookShell> bookShells=updateBookForm.getBookShells();
		
		ArrayList<BookType> bookTypes=updateBookForm.getBookTypes();
	             BookEdition  bookEdition;
		  		      bookEdition=bookEditionDao.getBookEditionById(Integer.parseInt(bookForm.getEditionId()));
		              book=new Book();
		              book.setBookId(Integer.parseInt(bookForm.getBookId()));
		              book.setBookName(bookForm.getBookName());
		              book.setIsbn(bookForm.getIsbn());
		              book.setCreateDate(DateFormat.stringToDate_dd_mm_yyy(bookForm.getCreateDate()));
		              book.setPublisherDate(DateFormat.stringToDate_dd_mm_yyy(bookForm.getPublisherDate()));
		              book.setQty(Integer.parseInt(bookForm.getQty()));
				      book.setBookEdition(bookEdition);
		              book.setBookGroup(updateBookForm.getBookGroup());
		              this.bookDao.update(book);
		              
		              for(BookType bt:bookTypes){
		            	  this.bookTypeDao.delete(bt);
		              }
		              for(BookShell bs:bookShells){
		            	  this.bookShellDao.delete(bs);
		              }
		              for(BookAuthor ba:bookAuthors){
		            	  this.bookAuthorDao.delete(ba);
		              }
		              
	}

}
