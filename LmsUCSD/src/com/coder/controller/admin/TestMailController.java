package com.coder.controller.admin;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.dao.StudentDao;
import com.coder.form.AdminForm;
import com.coder.form.AdminRegisterform;
import com.coder.form.AuthorForm;
import com.coder.form.AuthorRegisterForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.MemberRegisterForm;
import com.coder.form.RoleRegisterForm;
import com.coder.form.StudentForm;
import com.coder.form.StudentRegisterForm;
import com.coder.form.TeacherForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.form.TypeRegisterForm;
import com.coder.form.VerifyEmailForm;
import com.coder.model.Student;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.MemberServic;
import com.coder.servic.RoleServic;
import com.coder.servic.StudentRegisterServic;
import com.coder.servic.TeacherServic;
import com.coder.servic.TestCodeServic;
import com.coder.servic.AdminServic;
import com.coder.servic.AuthorRegisterService;
import com.coder.servic.AutoMailServic;
@Controller
@Transactional
public class TestMailController {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TeacherServic teacherServic;
	@Autowired
	private StudentRegisterServic studentRegisterServic;
	@Autowired
	private AutoMailServic autoMailServic;
	@Autowired
	private TestCodeServic testCodeServic;
	@Autowired
	private AdminServic adminServic;
	
	@RequestMapping("/testMailPath")
	public String roleRegisterDispatcher(@ModelAttribute("verifyEmailForm")VerifyEmailForm verifyEmailForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{     String from=req.getParameter("from");
	 HttpSession session=req.getSession(true);
	 session.setAttribute("from",from);
		verifyEmailForm=new VerifyEmailForm();
		verifyEmailForm.setMessage("Please send a code");
		modelMap.addAttribute("verifyEmailForm",verifyEmailForm);
		return "verifyMail";
	}
	@RequestMapping("/sentCodePath")
	public String sentCodeDispatcher(@ModelAttribute("verifyEmailForm")VerifyEmailForm verifyEmailForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{    HttpSession session=req.getSession(true);	
	String sendCode=req.getParameter("sendCode");
	String cancle=req.getParameter("cancle");
	System.out.println("sendCode="+sendCode);
	List<Student> students=this.studentDao.getStudentByEmail(verifyEmailForm.getEmail());
	
	/*if(students.size()!=0){
		verifyEmailForm=new VerifyEmailForm();
    	session.setAttribute("verifyEmailForm",null);
    	verifyEmailForm.setMessage("This Email already used!");
 		modelMap.addAttribute("verifyEmailForm",verifyEmailForm);
 		return "verifyMail"; 
	}*/  
	  if(cancle!=null){
		  return "userHome";
	  }
	 if(sendCode!=null){
		 VerifyEmailForm sendForm=new VerifyEmailForm();
		 System.out.println("verifyEmailForm.getEmail().endsWith="+ verifyEmailForm.getEmail().endsWith("ucsdwei.edu.mm"));
		if( verifyEmailForm.getEmail().endsWith("ucsdawei.edu.mm")){
		int a = (int)(Math.random()*9000)+1000;
	    verifyEmailForm.setCode(a+"");
	   
		// this.autoMailServic.sentCode(verifyEmailForm);
	    this.testCodeServic.setCodeDatabase(verifyEmailForm);
		 System.out.println("code="+verifyEmailForm.getCode());
		 session.setAttribute("sessionForm",verifyEmailForm);
		
		  sendForm.setEmail(verifyEmailForm.getEmail());
		  sendForm.setCode(null);
		  sendForm.setMessage("Sent Code!");
		}else{
		  sendForm.setMessage("Please make register with edu Mail!");	
		}
	      modelMap.addAttribute("verifyEmailForm", sendForm);
	    
		  return "verifyMail";
		     }else{
		    VerifyEmailForm  sessionForm=(VerifyEmailForm)session.getAttribute("sessionForm");
		    String  from=(String)session.getAttribute("from");
			Boolean flag=this.autoMailServic.testCodeServic(sessionForm, verifyEmailForm);
				  if(!flag){
				    verifyEmailForm=new VerifyEmailForm();
			    	session.setAttribute("verifyEmailForm",null);
			    	verifyEmailForm.setMessage("code invalid!");
			 		modelMap.addAttribute("verifyEmailForm",verifyEmailForm);
				  return "verifyMail"; 
			  }
			if(from.equals("student")){
		    
		    	StudentRegisterForm studentRegisterForm=new StudentRegisterForm();
		 		studentRegisterServic.prepareStudentRegister(studentRegisterForm);
		 		StudentForm studentForm=studentRegisterForm.getStudentForm();
		 		studentForm.setEmail(sessionForm.getEmail());
		 		studentRegisterForm.setStudentForm(studentForm);
		 		modelMap.addAttribute("studentRegisterForm",studentRegisterForm);
		 		return "studentRegister";
		     
		     }else if(from.equals("teacher")){
		    	 
		    			TeacherRegisterForm teacherRegisterForm=new TeacherRegisterForm();
		    			teacherServic.prepareTeacherRegister(teacherRegisterForm);
		    			TeacherForm teacherForm=teacherRegisterForm.getTeacherForm();
		    			teacherForm.setEmail(sessionForm.getEmail());
		    			teacherRegisterForm.setTeacherForm(teacherForm);
		    			modelMap.addAttribute("teacherRegisterForm",teacherRegisterForm);
		    			
		    			return "teacherRegister";
				    
		    	 
		     }else if(from.equals("admin")){
		    	AdminRegisterform adminRegisterForm=new AdminRegisterform();
		 		adminServic.prepareAdminRegister(adminRegisterForm);
		 		AdminForm adminForm=adminRegisterForm.getAdminForm();
		 		adminForm.setEmail(sessionForm.getEmail());
		 		adminRegisterForm.setAdminForm(adminForm);
		 		modelMap.addAttribute("adminRegisterForm",adminRegisterForm);
		 		return "adminRegister";
		     }
			return "userHome"; 
			
		}
	}
	
	
}
