package com.coder.servic;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coder.dao.BookDao;
import com.coder.dao.BookEditionDao;
import com.coder.dao.ShellDao;
import com.coder.form.BookForm;
import com.coder.form.BookRegisterForm;
import com.coder.model.Book;
import com.coder.model.BookEdition;
import com.coder.model.BookGroup;
import com.coder.model.Shell;
import com.coder.util.DateFormat;
import com.coder.util.FileUpload;
import com.coder.util.ServerPath;
@Service
@Repository("bookRegisterService")
public class BookRegisterServic {
	@Autowired
	private BookEditionDao bookEditionDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private ShellDao shellDao;

	public void prepareBookRegister(BookRegisterForm bookRegisterForm){
		BookForm bookForm=bookRegisterForm.getBookForm();
		
		if(bookForm!=null){
			int id=this.BookRegister(bookRegisterForm);
			bookForm.setBookId(id+"");
			BookEdition bookEdition=this.bookEditionDao.getBookEditionById(Integer.parseInt(bookForm.getEditionId()));
			bookForm.setEditionName(bookEdition.getEditionName());
			bookForm.setCreateDate(DateFormat.dateToStringFormat_dd_mm_yyyy(new Date()));
			bookRegisterForm.setBookForm(bookForm);
			}
		List<BookEdition> bookEditions=this.bookEditionDao.getBookEditions();
		for( BookEdition be:bookEditions){
			bookRegisterForm.getMapBookEditions().put(""+be.getEditionId(),""+be.getEditionName());
		}
		
	}
	private int BookRegister(BookRegisterForm bookRegisterForm){
		Book book=new Book();
		BookForm bookForm=bookRegisterForm.getBookForm();
		book.setBookName(bookForm.getBookName());
		book.setCreateDate(new Date());
		book.setIsbn(bookForm.getIsbn());
		book.setQty(Integer.parseInt(bookForm.getQty()));
		book.setPublisherDate(DateFormat.stringToDate_dd_mm_yyy(bookForm.getPublisherDate()));
		BookEdition bookEdition=new BookEdition();
		bookEdition.setEditionId(Integer.parseInt(bookForm.getEditionId()));
		BookGroup bookGroup=new BookGroup();
		bookGroup.setBookGroupId(Integer.parseInt(bookForm.getBookGroupId()));
		book.setBookEdition(bookEdition);
		book.setBookGroup(bookGroup);
		
		
		int id=bookDao.saveBook(book);
		 String serverPath=ServerPath.getPath();
		  
		  String adminPath=ServerPath.createFloder(serverPath+File.separator+"book");
		  for (MultipartFile multipartFile :bookForm.getImageFiles()) {
        	String fileName=id+"";

        		String url=adminPath+File.separator+fileName+".jpg";
        		FileUpload.uploadFile(multipartFile,url);
        		
        		break;
           
        }
		
		
		return id; 
	}

}
