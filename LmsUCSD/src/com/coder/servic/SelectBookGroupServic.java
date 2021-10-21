package com.coder.servic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.BookDao;
import com.coder.dao.BookGroupDao;
import com.coder.dao.ShellDao;
import com.coder.dao.TypeDao;
import com.coder.form.BookForm;
import com.coder.form.BookGroupForm;
import com.coder.form.BookGroupRegisterForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.TypeForm;
import com.coder.form.TypeRegisterForm;
import com.coder.model.Book;
import com.coder.model.BookGroup;
import com.coder.model.Shell;
import com.coder.model.Type;
import com.coder.util.DateFormat;
@Service
@Repository("selectBookGroupService")
public class SelectBookGroupServic {
	@Autowired
	private BookGroupDao bookGroupDao;
	

	public void prepareSelectBookGroup(BookGroupRegisterForm bookGroupRegisterForm){
		
		
		List<BookGroup> bookGroups=this.bookGroupDao.getBookGroups();
        for( BookGroup bs:bookGroups){
        	bookGroupRegisterForm.getMapBookGroups().put(""+bs.getBookGroupId(),""+bs.getGroupName());
		}
       BookGroupForm bookGroupForm=bookGroupRegisterForm.getBookGroupForm();
      
       if(bookGroupForm!=null){
    	   String bgId=bookGroupForm.getBookGroupId();
    	   if(bgId!=null){
        BookGroup bookGroup=this.bookGroupDao.getBookGroupById(Integer.parseInt(bookGroupForm.getBookGroupId()));
        bookGroupForm.setBookGroupId(bookGroup.getBookGroupId()+"");
        bookGroupForm.setGroupName(bookGroup.getGroupName());
        bookGroupForm.setGroupCode(bookGroup.getGroupCode());
        bookGroupRegisterForm.setBookGroupForm(bookGroupForm);
    	   }
	}
	}

}
