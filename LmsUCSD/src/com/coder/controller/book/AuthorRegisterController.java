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
import com.coder.servic.AuthorRegisterService;

@Controller
@Transactional
public class AuthorRegisterController {
/*	@Autowired
	private authorLoginService authorService;
	@RequestMapping("/authorRegisterPath")
	public String TypeRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		AuthorRegisterForm authorRegisterForm=new AuthorRegisterForm();
		modelMap.addAttribute("authorRegisterForm",authorRegisterForm);
		
		return "authorRegister";
	}
	
	@RequestMapping("/authorRegisterSubmitPath")
	public String userRegisterSubmitDispatcher(@ModelAttribute("authorRegisterForm") AuthorRegisterForm authorRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		 authorService.AddAuthorPrepare(authorRegisterForm);
		
	    modelMap.addAttribute("authorRegisterForm",new AuthorRegisterForm());
	   return "authorRegister";
		}else{
			return "home";
		}
		
	
	}*/
	
}
