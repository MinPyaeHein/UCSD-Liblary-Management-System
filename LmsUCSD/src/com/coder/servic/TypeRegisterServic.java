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
@Repository("typeRegisterService")
public class TypeRegisterServic {
	@Autowired
	private TypeDao typeDao;
	@Autowired
	private BookGroupDao bookGroupDao;
	
	public void prepareTypeRegister(TypeRegisterForm typeRegisterForm){
		TypeForm typeForm=typeRegisterForm.getTypeForm();
		if((typeForm!=null)&&(typeForm.getTypeId()!=null)){
			Type type=typeDao.getTypeById(Integer.parseInt(typeForm.getTypeId()));
		     typeForm.setTypeId(type.getTypeId()+"");
		     typeForm.setTypeName(type.getTypeName());
		     typeForm.setTypeCode(type.getTypeCode());
		     typeRegisterForm.setTypeForm(typeForm);
		}else if(typeForm!=null){
			this.typeRegister(typeRegisterForm);
			   typeForm=null;
			   typeRegisterForm.setTypeForm(typeForm);
		  }
	
		List<Type> types=this.typeDao.getTypesByGroupIdCriteria(Integer.parseInt(typeRegisterForm.getBookGroupId()),"bookGroupId");
		typeRegisterForm.setTypes(types);
     
      
	
	}
	private int typeRegister(TypeRegisterForm typeRegisterForm){
		Type type=new Type();
		BookGroup bookGroup=new BookGroup(); 
		TypeForm typeForm=typeRegisterForm.getTypeForm();
		
		type.setTypeCode(typeForm.getTypeCode());
		type.setTypeName(typeForm.getTypeName());
		bookGroup.setBookGroupId(Integer.parseInt(typeRegisterForm.getBookGroupId()));
		type.setBookGroup(bookGroup);
		int id=typeDao.saveType(type);
		
		
	return id; 
	}

}
