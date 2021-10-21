package com.coder.controller.book;

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
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookGroupRegisterServic;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.TypeRegisterServic;
import com.coder.servic.AuthorRegisterService;

@Controller
@Transactional
public class TypeRegisterController {
	/*@Autowired
	private TypeRegisterServic typeRegisterServic;
	@RequestMapping("/typeRegisterPath")
	public String TypeRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		TypeRegisterForm typeRegisterForm=new TypeRegisterForm();
		modelMap.addAttribute("typeRegisterForm",typeRegisterForm);
		typeRegisterServic.prepareTypeRegister(typeRegisterForm);
		return "typeRegister";
	}
	
	@RequestMapping("/typeRegisterSubmitPath")
	public String bookRegisterSubmitDispatcher(@ModelAttribute("typeRegisterForm") TypeRegisterForm typeRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		 typeRegisterServic.prepareTypeRegister(typeRegisterForm);
		 modelMap.addAttribute("typeRegisterForm",typeRegisterForm);
	     return "typeRegister";
		}else{
			return "home";
		}
	
	}*/
	
}
