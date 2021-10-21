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

import com.coder.form.AcademicYearRegisterForm;
import com.coder.form.AuthorRegisterForm;
import com.coder.form.BookGroupRegisterForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.GreadRegisterForm;
import com.coder.form.MajorRegisterForm;
import com.coder.servic.BookGroupRegisterServic;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.GreadRegisterServic;
import com.coder.servic.MajorRegisterServic;
import com.coder.servic.AcademicYearRegisterServic;
import com.coder.servic.AuthorRegisterService;

@Controller
@Transactional
public class AcdemicYearRegisterController {
	@Autowired
	private AcademicYearRegisterServic academicYearRegisterServic;
	@RequestMapping("/academicYearRegisterPath")
	public String majorRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		AcademicYearRegisterForm academicYearRegisterForm=new AcademicYearRegisterForm();
		modelMap.addAttribute("academicYearRegisterForm",academicYearRegisterForm);
		academicYearRegisterServic.prepareAcademicYearRegister(academicYearRegisterForm);
		return "academicYearRegister";
	}
	
	@RequestMapping("/academicYearRegisterSubmitPath")
	public String greadRegisterSubmitDispatcher(@ModelAttribute("academicYearRegisterForm") AcademicYearRegisterForm academicYearRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		 academicYearRegisterServic.prepareAcademicYearRegister(academicYearRegisterForm);
		 modelMap.addAttribute("academicYearRegisterForm",academicYearRegisterForm);
	     return "academicYearRegister";
	     }else{
	     return "userHome";
	     }
		
	
	}
	
}
