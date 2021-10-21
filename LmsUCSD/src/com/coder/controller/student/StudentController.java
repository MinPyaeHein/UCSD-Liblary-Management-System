package com.coder.controller.student;

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

import com.coder.form.AuthorForm;
import com.coder.form.AuthorRegisterForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.StudentRegisterForm;
import com.coder.form.TypeRegisterForm;
import com.coder.form.VerifyEmailForm;
import com.coder.model.Login;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.StudentRegisterServic;
import com.coder.servic.AuthorRegisterService;

@Controller
@Transactional
public class StudentController {
	@Autowired
	private StudentRegisterServic studentRegisterServic;
	@RequestMapping("/studentRegisterPath")
	public String studentRegisterDispatcher(@ModelAttribute("studentRegisterForm")StudentRegisterForm studentRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
	    studentRegisterForm=new StudentRegisterForm();
		modelMap.addAttribute("studentRegisterForm",studentRegisterForm);
		studentRegisterServic.prepareStudentRegister(studentRegisterForm);
		return "studentRegister";
	}
	
	
	
	@Autowired
    private StudentRegisterServic studentRegisterService;
	@RequestMapping("/studentRegisterSubmitPath")
	public String studentRegisterSubmitDispatcher(@ModelAttribute("StudentRegisterForm") StudentRegisterForm studentRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   String save=req.getParameter("save");
	    String exit=req.getParameter("exit");	
	    if(save!=null){
		this.studentRegisterService.prepareStudentRegister(studentRegisterForm);
		VerifyEmailForm verifyEmailForm=new VerifyEmailForm();
		verifyEmailForm.setMessage("Please send a code");
		modelMap.addAttribute("verifyEmailForm",verifyEmailForm);
		return "verifyMail";
	    }else{
	    return "userHome";	
	    }
	}
	
	@RequestMapping("/showAllStudentPath")
	public String showAllStuDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   StudentRegisterForm studentRegisterForm=new StudentRegisterForm();
		this.studentRegisterService.showAllStudent(studentRegisterForm);
		modelMap.addAttribute("studentRegisterForm",studentRegisterForm);
		return "showAllStudent";
	}
	@RequestMapping("/showDetailStudentPath")
	public String showUserDetailDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{  String exit= req.getParameter("exit");
	if(exit==null){
	HttpSession session=req.getSession(true);	
	Login login=(Login) session.getAttribute("loginObj");
	
	StudentRegisterForm studentRegisterForm=new StudentRegisterForm();
	if(login==null){
		 String studentId=req.getParameter("frmStudentId");
		 studentRegisterForm.setStudentId(studentId);
	}else{
		studentRegisterForm.setStudentId(login.getUserId());
	}
	this.studentRegisterServic.showUserDetail(studentRegisterForm);
	modelMap.addAttribute("student", studentRegisterForm.getStudent());
		return "showDetailStudent";
	}else{
		return "userHome";
	}
	}
	@RequestMapping("/showRentStudentPath")
	public String showRentStudentDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{  String exit= req.getParameter("exit");
	if(exit==null){
	HttpSession session=req.getSession(true);	
	Login login=(Login) session.getAttribute("loginObj");
	StudentRegisterForm studentRegisterForm=new StudentRegisterForm();
	studentRegisterForm.setStudentId(login.getUserId());
	this.studentRegisterServic.showRentStudent(studentRegisterForm);
	modelMap.addAttribute("studentRegisterForm", studentRegisterForm);
		return "showRentStudent";
	}else{
		return "userHome";
	}
	}
	@RequestMapping("/showReturnStudentPath")
	public String showReturnStudentDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{  String exit= req.getParameter("exit");
	if(exit==null){
	HttpSession session=req.getSession(true);	
	Login login=(Login) session.getAttribute("loginObj");
	StudentRegisterForm studentRegisterForm=new StudentRegisterForm();
	studentRegisterForm.setStudentId(login.getUserId());
	this.studentRegisterServic.showReturnStudent(studentRegisterForm);
	modelMap.addAttribute("studentRegisterForm", studentRegisterForm);
		return "showReturnStudent";
	}else{
		return "userHome";
	}
	}
	
}
