package com.coder.servic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.LoginDao;
import com.coder.form.LoginForm;
import com.coder.model.Login;


@Service
@Repository("loginService")
public class LoginServic {
	@Autowired
	private LoginDao loginDao;
		public void LoginRegister(LoginForm loginForm){
	
		Login login=new Login();
		
		login.setPassword(loginForm.getPassword());
		login.setUserName(loginForm.getUserName());
		login.setUserId(loginForm.getUserId());
		this.loginDao.saveLogin(login);
		}
	    public Login testLogin(LoginForm loginForm){
		Login login=loginDao.getLoginByUserIdAndPassword(loginForm.getUserId(),loginForm.getPassword());
		
		return login;
		
	}
	
}
