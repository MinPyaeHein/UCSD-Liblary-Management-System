package com.coder.servic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AuthorDao;
import com.coder.dao.BookAuthorDao;
import com.coder.dao.BookDao;
import com.coder.dao.BookShellDao;
import com.coder.dao.BookTypeDao;
import com.coder.dao.ShellDao;
import com.coder.dao.TypeDao;
import com.coder.form.AuthorForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.SaveBookConfrimForm;
import com.coder.form.ShellForm;
import com.coder.form.TypeForm;
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

@Service
@Repository("saveBookConfrimServic")
public class SaveBookConfrimServic {
	
	@Autowired
	private BookDao bookDao;
	@Autowired
	private BookShellDao bookShellDao;
	@Autowired
	private BookTypeDao bookTypeDao;
	@Autowired
	private BookAuthorDao bookAuthorDao;
	public void prepareSaveBookConfrim(SaveBookConfrimForm saveBookConfrimForm){
		if(saveBookConfrimForm.getBookId()!=null){
		int bookId=Integer.parseInt(saveBookConfrimForm.getBookId());
		ArrayList<AuthorForm> authorForms=saveBookConfrimForm.getAuthorForms();
		ArrayList<TypeForm> typeForms=saveBookConfrimForm.getTypeForms();
		ArrayList<ShellForm> shellForms=saveBookConfrimForm.getShellForms();
		Book book=this.bookDao.getBookById(bookId);
		
	      for(AuthorForm af:authorForms){
			BookAuthor bookAuthor=new BookAuthor();
			BookAuthorId bookAuthorId=new BookAuthorId();
			bookAuthorId.setAuthorId(Integer.parseInt(af.getAuthorId()));
			bookAuthorId.setBookId(bookId);
			bookAuthor.setBook(book);
			bookAuthor.setId(bookAuthorId);
			
			Boolean t=(Boolean) this.bookAuthorDao.saveBookAuthor(bookAuthor);
			
			}
	
	
		for(TypeForm tf:typeForms){
			BookType bookType=new BookType();
			BookTypeId bookTypeId=new BookTypeId();
			bookTypeId.setBookId(bookId);
			bookTypeId.setTypeId(Integer.parseInt(tf.getTypeId()));
			bookType.setBook(book);
			bookType.setId(bookTypeId);
			
			this.bookTypeDao.saveBookType(bookType);
			}
		for(ShellForm sf:shellForms){
			BookShell bookShell=new BookShell();
			BookShellId bookShellId=new BookShellId();
			bookShellId.setBookId(bookId);
			bookShellId.setShellId(Integer.parseInt(sf.getShellId()));
			bookShell.setId(bookShellId);
			
			bookShell.setBook(book);
			this.bookShellDao.saveBookShell(bookShell);
		}}
		
	List<Book> books=this.bookDao.getBooks();
     
	
	saveBookConfrimForm.setBooks(books);
		
 	}
	public void prepareShowBookDetail(SaveBookConfrimForm saveBookConfrimForm){
		Book book=this.bookDao.getBookById(Integer.parseInt(saveBookConfrimForm.getBookId()));
		saveBookConfrimForm.setBook(book);
	}

}
