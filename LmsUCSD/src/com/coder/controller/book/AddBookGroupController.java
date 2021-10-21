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
import com.coder.form.TypeForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookGroupRegisterServic;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.SelectBookGroupServic;
import com.coder.servic.TypeRegisterServic;
import com.coder.servic.AuthorRegisterService;

@Controller
@Transactional
public class AddBookGroupController {
	@Autowired
	private SelectBookGroupServic selectBookGroupServic;
	@Autowired
	private TypeRegisterServic typeRegisterServic;
	@RequestMapping("/selectBookGroupPath")
	public String selectBookGroupDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		
		BookGroupRegisterForm bookGroupRegisterForm=new BookGroupRegisterForm();
		modelMap.addAttribute("bookGroupRegisterForm",bookGroupRegisterForm);
		selectBookGroupServic.prepareSelectBookGroup(bookGroupRegisterForm);
		
		return "selectBookGroup";
	}
	
	@RequestMapping("/selectBookGroupSubmitPath")
	public String bookRegisterSubmitDispatcher(@ModelAttribute("bookGroupRegisterForm") BookGroupRegisterForm bookGroupRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		HttpSession session=req.getSession(true);	
	    ArrayList<TypeForm> typeForms=new ArrayList<>();
	    session.setAttribute("typeForms", typeForms);
	   
	   
		TypeRegisterForm typeRegisterForm=new TypeRegisterForm();
	
		typeRegisterForm.setBookGroupId(bookGroupRegisterForm.getBookGroupForm().getBookGroupId());
		
		
		modelMap.addAttribute("typeRegisterForm",typeRegisterForm);
		this.selectBookGroupServic.prepareSelectBookGroup(bookGroupRegisterForm);
		session.setAttribute("bookGroupForm",bookGroupRegisterForm.getBookGroupForm());
	   typeRegisterServic.prepareTypeRegister(typeRegisterForm);
		
		return "addBookType";
	    
		
	
	}
	
}
