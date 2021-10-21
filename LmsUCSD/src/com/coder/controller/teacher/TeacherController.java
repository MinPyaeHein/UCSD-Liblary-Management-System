package com.coder.controller.teacher;
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
import com.coder.form.TeacherForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.form.TypeRegisterForm;
import com.coder.form.VerifyEmailForm;
import com.coder.model.Login;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.StudentRegisterServic;
import com.coder.servic.TeacherServic;
import com.coder.util.PrjSubFunction;
import com.coder.servic.AuthorRegisterService;
@Controller
@Transactional
public class TeacherController {
	@Autowired
	private TeacherServic teacherServic;
	@RequestMapping("/teacherRegisterPath")
	public String studentRegisterDispatcher(@ModelAttribute("teacherRegisterForm")TeacherRegisterForm teacherRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		teacherRegisterForm=new TeacherRegisterForm();
		modelMap.addAttribute("teacherRegisterForm",teacherRegisterForm);
		teacherServic.prepareTeacherRegister(teacherRegisterForm);
		return "teacherRegister";
	}
	@RequestMapping("/teacherRegisterSubmitPath")
	public String studentRegisterSubmitDispatcher(@ModelAttribute("teacherRegisterForm")TeacherRegisterForm teacherRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		 HttpSession session=req.getSession(true);		
    String save=req.getParameter("save");
    String exit=req.getParameter("exit");	
    if(save!=null){
    	Boolean flag=PrjSubFunction.teacherRegTest(teacherRegisterForm);
    	if(flag){
		this.teacherServic.prepareTeacherRegister(teacherRegisterForm);
    	}else{
    		
    		VerifyEmailForm  sessionForm=(VerifyEmailForm)session.getAttribute("sessionForm");
    		TeacherRegisterForm teacherRegisterForm1=new TeacherRegisterForm();
    		this.teacherServic.prepareTeacherRegister(teacherRegisterForm1);
    		TeacherForm teacherForm=teacherRegisterForm1.getTeacherForm();
    		teacherForm.setEmail(sessionForm.getEmail());
    		teacherRegisterForm1.setTeacherForm(teacherForm);
    		teacherRegisterForm1.setMessage("Plesae input the data correctly!");
    		modelMap.addAttribute("teacherRegisterForm",teacherRegisterForm1);
    		
    		return "teacherRegister";
    	}
		VerifyEmailForm verifyEmailForm=new VerifyEmailForm();
		verifyEmailForm.setMessage("Please send a code");
		modelMap.addAttribute("verifyEmailForm",verifyEmailForm);
		return "verifyMail";
    }else{
	    return "userHome";	
	    }
	}
	@RequestMapping("/showAllTeacherPath")
	public String showAllTeacherDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   TeacherRegisterForm teacherRegisterForm=new TeacherRegisterForm();
		this.teacherServic.showAllTeacher(teacherRegisterForm);
		modelMap.addAttribute("teacherRegisterForm",teacherRegisterForm);
		return "showAllTeacher";
	}
	
	@RequestMapping("/showDetailTeacherPath")
	public String showTeacherDetailDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{  String exit= req.getParameter("exit");
	   String teacherId= req.getParameter("frmTeacherId");
	if(exit==null){
	HttpSession session=req.getSession(true);	
	Login login=(Login) session.getAttribute("loginObj");
	TeacherRegisterForm teacherRegisterForm=new TeacherRegisterForm();
	if(login!=null){
	teacherRegisterForm.setTeacherId(login.getUserId());
	}else{
    teacherRegisterForm.setTeacherId(teacherId);	
	}
	this.teacherServic.showTeacherDetail(teacherRegisterForm);
	modelMap.addAttribute("teacher", teacherRegisterForm.getTeacher());
		return "showDetailTeacher";
	}else{
		return "userHome";
	}
	}
	@RequestMapping("/showRentTeacherPath")
	public String showRentStudentDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{  String exit= req.getParameter("exit");
	if(exit==null){
	HttpSession session=req.getSession(true);	
	Login login=(Login) session.getAttribute("loginObj");
	TeacherRegisterForm teacherRegisterForm=new TeacherRegisterForm();
	if(login==null){
		 String teacherId=req.getParameter("frmTeacherId");
		 teacherRegisterForm.setTeacherId(teacherId);
	}else{
		teacherRegisterForm.setTeacherId(login.getUserId());
	}
	
	teacherRegisterForm.setTeacherId(login.getUserId());
	this.teacherServic.showRentTeacher(teacherRegisterForm);
	modelMap.addAttribute("teacherRegisterForm", teacherRegisterForm);
		return "showRentTeacher";
	}else{
		return "userHome";
	}
	}
	@RequestMapping("/showReturnTeacherPath")
	public String showReturnStudentDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{  String exit= req.getParameter("exit");
	if(exit==null){
	HttpSession session=req.getSession(true);	
	Login login=(Login) session.getAttribute("loginObj");
	TeacherRegisterForm teacherRegisterForm=new TeacherRegisterForm();
	teacherRegisterForm.setTeacherId(login.getUserId());
	this.teacherServic.showRentTeacher(teacherRegisterForm);
	modelMap.addAttribute("teacherRegisterForm", teacherRegisterForm);
		return "showReturnTeacher";
	}else{
		return "userHome";
	}
	}
	
}
