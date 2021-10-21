package com.coder.servic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.BookDao;
import com.coder.dao.BookGroupDao;
import com.coder.dao.GreadDao;
import com.coder.dao.MajorDao;
import com.coder.dao.ShellDao;
import com.coder.dao.TypeDao;
import com.coder.form.BookForm;
import com.coder.form.BookGroupRegisterForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.GreadForm;
import com.coder.form.GreadRegisterForm;
import com.coder.form.MajorForm;
import com.coder.form.MajorRegisterForm;
import com.coder.form.TypeForm;
import com.coder.form.TypeRegisterForm;
import com.coder.model.Book;
import com.coder.model.BookGroup;
import com.coder.model.Gread;
import com.coder.model.Major;
import com.coder.model.Shell;
import com.coder.model.Type;
import com.coder.util.DateFormat;
@Service
@Repository("greadRegisterService")
public class GreadRegisterServic {
	@Autowired
	private GreadDao greadDao;
	
	
	public void prepareGreadRegister(GreadRegisterForm greadRegisterForm){
		GreadForm greadForm=greadRegisterForm.getGreadForm();
		if(greadForm!=null){
			
			this.greadRegister(greadRegisterForm);
			greadForm=null;
		  }
		greadRegisterForm.setGreadForm(greadForm);
		List<Gread> greads=this.greadDao.getGreads();
		greadRegisterForm.setGreads(greads);
     
      
	
	}
	private int greadRegister(GreadRegisterForm greadRegisterForm){
		Gread gread=new Gread();
		GreadForm greadForm=greadRegisterForm.getGreadForm();
		gread.setGreadName(greadForm.getGreadName());
		gread.setGreadNo(greadForm.getGreadNo());
		int id=this.greadDao.saveGread(gread);
		return id; 
	}

}
