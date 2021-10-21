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

import com.coder.form.AuthorRegisterForm;
import com.coder.form.BookGroupRegisterForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.MajorRegisterForm;
import com.coder.servic.BookGroupRegisterServic;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.MajorRegisterServic;
import com.coder.servic.AuthorRegisterService;

@Controller
@Transactional
public class MajorRegisterController {
	@Autowired
	private MajorRegisterServic majorRegisterServic;
	@RequestMapping("/majorRegisterPath")
	public String majorRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		MajorRegisterForm majorRegisterForm=new MajorRegisterForm();
		modelMap.addAttribute("majorRegisterForm",majorRegisterForm);
		majorRegisterServic.prepareMajorRegister(majorRegisterForm);
		return "majorRegister";
	}
	
	@RequestMapping("/majorRegisterSubmitPath")
	public String majorRegisterSubmitDispatcher(@ModelAttribute("majorRegisterForm") MajorRegisterForm majorRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		 majorRegisterServic.prepareMajorRegister(majorRegisterForm);
		 modelMap.addAttribute("majorRegisterForm",majorRegisterForm);
	     return "majorRegister";
	     }else{
	     return "userHome";
	     }
		
	
	}
	
}
