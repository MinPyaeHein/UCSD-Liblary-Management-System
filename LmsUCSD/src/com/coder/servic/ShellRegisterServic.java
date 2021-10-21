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
import com.coder.form.ShellForm;
import com.coder.form.ShellRegisterForm;
import com.coder.form.TypeForm;
import com.coder.form.TypeRegisterForm;
import com.coder.model.Book;
import com.coder.model.BookGroup;
import com.coder.model.Shell;
import com.coder.model.Type;
import com.coder.util.DateFormat;
@Service
@Repository("shellRegisterServic")
public class ShellRegisterServic {
	@Autowired
	private ShellDao shellDao;
	

	public void prepareShellRegister(ShellRegisterForm shellRegisterForm){
		ShellForm shellForm=shellRegisterForm.getShellForm();
		if(shellForm!=null){
			if(shellForm.getShellId()!=null){
				Shell shell=this.shellDao.getShellById(Integer.parseInt(shellForm.getShellId()));
				shellForm.setShellId(shell.getShellId()+"");
				shellForm.setShellNo(shell.getShellNo());
				shellRegisterForm.setShellForm(shellForm);
			}else{
			this.shellRegister(shellRegisterForm);
			shellForm=null;
			shellRegisterForm.setShellForm(shellForm);}
		  }
		
		List<Shell> shells=this.shellDao.getShells();
		System.out.println("Shell="+shells.size());
		shellRegisterForm.setShells(shells);
	}
	private int shellRegister(ShellRegisterForm shellRegisterForm){
		Shell shell=new Shell();
		 
		ShellForm shellForm=shellRegisterForm.getShellForm();
		shell.setShellNo(shellForm.getShellNo());
		int id=this.shellDao.saveShell(shell);
		return id; 
	}
	
}
