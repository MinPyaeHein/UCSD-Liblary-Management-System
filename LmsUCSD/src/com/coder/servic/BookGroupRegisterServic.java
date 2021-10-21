package com.coder.servic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.BookGroupDao;
import com.coder.form.BookGroupForm;
import com.coder.form.BookGroupRegisterForm;
import com.coder.model.BookGroup;

@Service
@Repository("bookGroupRegisterServic")
public class BookGroupRegisterServic {
@Autowired
private BookGroupDao bookGroupDao;
public void prepareBookGroupRegister(BookGroupRegisterForm bookGroupRegisterForm){
	if(bookGroupRegisterForm.getBookGroupForm()!=null){
		this.bookGroupRegister(bookGroupRegisterForm);
	}
	bookGroupRegisterForm.setBookGroups(this.bookGroupDao.getBookGroups());
	
}
public int bookGroupRegister(BookGroupRegisterForm bookGroupRegisterForm){
	BookGroupForm bookGroupForm=bookGroupRegisterForm.getBookGroupForm();
	BookGroup bookGroup=new BookGroup();
	bookGroup.setGroupCode(bookGroupForm.getGroupCode());
	bookGroup.setGroupName(bookGroupForm.getGroupName());
	int id=this.bookGroupDao.saveBookGroup(bookGroup);
	return id;
	
}

}
