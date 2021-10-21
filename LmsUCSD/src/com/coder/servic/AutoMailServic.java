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
import com.coder.form.MailForm;
import com.coder.form.VerifyEmailForm;
import com.coder.model.RentReturnStudent;
import com.coder.model.RentReturnTeacher;
import com.coder.util.DateFormat;
import com.coder.util.PrjSubFunction;

@Service
@Repository("autoMailServic")
public class AutoMailServic {
@Autowired
private RentReturnTeacherDao rentReturnTeacherDao;
@Autowired
private RentReturnStudentDao rentReturnStudentDao;
@Autowired
private GeneralService generalService;
@Autowired
private TestCodeServic testCodeServic;


@Scheduled(fixedDelay=5000)
public void autoMail(){
	            autoMailTeacher();
	            autoMailStudent();
				
				 
				
	
}
public void autoMailStudent(){
	  this.testCodeServic.sentCode();
	System.out.println("Working Student");
	List<RentReturnStudent> rentReturnStudents=rentReturnStudentDao.getRentReturnStuListBySent();
	System.out.println("getRentReturnStuListBySent()="+rentReturnStudents.size());
	if(rentReturnStudents!=null){
		  for(RentReturnStudent rrs:rentReturnStudents){
			 /* Date addDate=DateFormat.subDays(+1);
			  String dueDate=rrs.getDueDate()+"";
			  String testDate=DateFormat.dateToString_DB_Format(addDate);
			  
			  if(testDate.equals(dueDate)){*/
				  String subject="";
				  MailForm mailForm=new MailForm();
				  System.out.println("rrs.getStudent().getEmail()="+rrs.getStudent().getEmail().trim());
				  mailForm.setToMail(rrs.getStudent().getEmail().trim());
				  subject+="Student Name="+rrs.getStudent().getStudentName()+"\n";
				  subject+="Book Name="+rrs.getBook().getBookName()+"\n";
				  subject+="Due Date="+DateFormat.dateToStringFormat_dd_mm_yyyy(rrs.getDueDate())+"\n";
				  subject+="You have to return it tomorrow.\n";
				  mailForm.setSubject(subject);
				  mailForm.setContent("Dear Member,I'd like to talk to you about a Your Rent Book\n");
				  System.out.println("Arriving Auto mail servic Student");
				  generalService.processSendMail(mailForm);
				  rrs.setSent("sent");
				  this.rentReturnStudentDao.updateRentReturnStudent(rrs);
}
		  }
	}


public void autoMailTeacher(){
	this.testCodeServic.sentCodeUser();
	System.out.println("Working Teacher");
	List<RentReturnTeacher> rentReturnTeachers=rentReturnTeacherDao.getRentReturnTeacherBySent();
	System.out.println("getRentReturnTeacherBySent()="+rentReturnTeachers.size());
	if(rentReturnTeachers!=null){
		  for(RentReturnTeacher rrs:rentReturnTeachers){
			  Date addDate=DateFormat.subDays(+1);
			  String dueDate=rrs.getDueDate()+"";
			  String testDate=DateFormat.dateToString_DB_Format(addDate);
			  if(testDate.equals(dueDate)){
				  String subject="";
				  MailForm mailForm=new MailForm();
				  mailForm.setToMail(rrs.getTeacher().getEmail().trim());
				  subject+=rrs.getTeacher().getTeacherName()+"\n";
				  subject+="Book Name="+rrs.getBook().getBookName()+"\n";
				  subject+="Due Date="+DateFormat.dateToStringFormat_dd_mm_yyyy(rrs.getDueDate())+"\n";
				  subject+="You have to return it tomorrow.\n";
				  mailForm.setSubject(subject);
				  mailForm.setContent("Dear Customer,I'd like to talk to you about a Your Rent Book\n");
				  System.out.println("Arriving Auto mail servic Teacher");
				  generalService.processSendMail(mailForm);
				  int sent=0;
				
				  rrs.setSent(sent);
				  this.rentReturnTeacherDao.updateRentReturnTeacher(rrs);
			  }
		  }
	}  
}
/*public void sentCode(VerifyEmailForm verifyEmailForm){
				  String subject="";
				  MailForm mailForm=new MailForm();
				  mailForm.setToMail(verifyEmailForm.getEmail());
				  subject+="Mail verify code<"+verifyEmailForm.getCode()+">\n";
				  mailForm.setSubject(subject);
				  mailForm.setContent("Dear Customer,Mail verify code from UCSD Liblary\n");
				  generalService.processSendMail(mailForm);
				
}*/
public Boolean testCodeServic(VerifyEmailForm sessionForm,VerifyEmailForm verifyEmailForm){
	try{
	Boolean flag=false;
	System.out.println(sessionForm.getEmail()+"=="+verifyEmailForm.getEmail()+"&&"+sessionForm.getCode()+"=="+verifyEmailForm.getCode());
	if((sessionForm.getEmail().equals(verifyEmailForm.getEmail()))&&(sessionForm.getCode().equals(verifyEmailForm.getCode()))){
		
		flag=true;
	}
	return flag;
	}catch ( Exception e) {
	return false;
	}
	
}
}
