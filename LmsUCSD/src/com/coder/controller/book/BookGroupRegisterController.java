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
import com.coder.servic.BookGroupRegisterServic;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.AuthorRegisterService;

@Controller
@Transactional
public class BookGroupRegisterController {
	@Autowired
	private BookGroupRegisterServic bookGroupRegisterServic;
	@RequestMapping("/bookGroupRegisterPath")
	public String TypeRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		BookGroupRegisterForm bookGroupRegisterForm=new BookGroupRegisterForm();
		modelMap.addAttribute("bookGroupRegisterForm",bookGroupRegisterForm);
		bookGroupRegisterServic.prepareBookGroupRegister(bookGroupRegisterForm);
		return "bookGroupRegister";
	}
	
	@RequestMapping("/bookGroupRegisterSubmitPath")
	public String bookRegisterSubmitDispatcher(@ModelAttribute("bookGroupRegisterForm") BookGroupRegisterForm bookGroupRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		String finish=req.getParameter("finish");
		String save=req.getParameter("save");
		if(save!=null){
		 bookGroupRegisterServic.prepareBookGroupRegister(bookGroupRegisterForm);
		 modelMap.addAttribute("bookGroupRegisterForm",bookGroupRegisterForm);
	     return "bookGroupRegister";}else{
	     return "home";
	     }
		
	
	}
	
}
