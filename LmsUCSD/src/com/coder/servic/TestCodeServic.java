package com.coder.servic;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.coder.dao.RentReturnStudentDao;
import com.coder.dao.RentReturnTeacherDao;
import com.coder.dao.TestCodeDao;
import com.coder.form.MailForm;
import com.coder.form.SuccessUserForm;
import com.coder.form.VerifyEmailForm;
import com.coder.model.RentReturnStudent;
import com.coder.model.RentReturnTeacher;
import com.coder.model.TestCode;
import com.coder.util.DateFormat;
import com.coder.util.PrjSubFunction;

@Service
@Repository("testCodeServic")
public class TestCodeServic {
@Autowired
private TestCodeDao testCodeDao;
@Autowired
private GeneralService generalService;
public void setCodeDatabase(VerifyEmailForm verifyEmailForm){
	TestCode testCode=new TestCode();
	testCode.setCode(verifyEmailForm.getCode());
	testCode.setMail(verifyEmailForm.getEmail());
	testCode.setStatus("notsent");
	this.testCodeDao.saveTestCode(testCode);
}
public void setSuccessUserDatabase(SuccessUserForm successUserForm){
	TestCode testCode=new TestCode();
	testCode.setCode(successUserForm.getId());
	testCode.setMail(successUserForm.getMail()+","+successUserForm.getPassword());
	testCode.setStatus(successUserForm.getMessage());
	
	this.testCodeDao.saveTestCode(testCode);
}
public void sentCode(){
	              List<TestCode> testCodes=this.testCodeDao.getTestCodeByNotSent();
	              System.out.println("testCodes.size()="+testCodes.size());
	              for(TestCode testCode:testCodes){
				  String subject="";
				  MailForm mailForm=new MailForm();
				  mailForm.setToMail(testCode.getMail());
				  subject+="Mail verify code<"+testCode.getCode()+">\n";
				  mailForm.setSubject(subject);
				  mailForm.setContent(subject+"Dear Customer,Mail verify code from UCSD Liblary\n");
				  generalService.processSendMail(mailForm);
				  this.testCodeDao.delete(testCode);
	              }
	              
}  
 public void sentCodeUser(){
		          List<TestCode> testCodes=this.testCodeDao.getTestCodeByUser();
		          System.out.println("testCodes.size()User="+testCodes.size());
		          for(TestCode testCode:testCodes){
			      String subject="";
					  MailForm mailForm=new MailForm();
					
					  String UID=testCode.getCode();
					  String mailPass=testCode.getMail();
					  String[] idPass=mailPass.split(",");
					  
					  String mail=idPass[0];
					  String pass=idPass[1];
					  
					  if(UID.startsWith("SID")){
						  subject+="UCSD student Liblary Account has been successfully completed\n";  
					  }else if(UID.startsWith("TID")){
						  subject+=subject+="UCSD teacher Liblary Account has been successfully completed\n"; 
					  }else if(UID.startsWith("ID")){
						  subject+=subject+="UCSD admin Liblary Account has been successfully completed\n"; 
					  }
					  mailForm.setToMail(mail.trim());
					  mailForm.setSubject(subject);
					  mailForm.setContent("Dear Customer,\n"+
					                       "UserID="+UID+"\n"+
					                       "Password="+pass+"\n"+
							               "from UCSD Liblary\n");
					  generalService.processSendMail(mailForm);
					  this.testCodeDao.delete(testCode);
		              }
				
}
public Boolean testCodeServic(VerifyEmailForm sessionForm,VerifyEmailForm verifyEmailForm){
	Boolean flag=false;
	System.out.println(sessionForm.getEmail()+"=="+verifyEmailForm.getEmail()+"&&"+sessionForm.getCode()+"=="+verifyEmailForm.getCode());
	if((sessionForm.getEmail().equals(verifyEmailForm.getEmail()))&&(sessionForm.getCode().equals(verifyEmailForm.getCode()))){
		
		flag=true;
	}
	return flag;
	
}
}
