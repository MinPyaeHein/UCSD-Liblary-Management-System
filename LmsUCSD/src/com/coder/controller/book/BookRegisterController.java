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

import com.coder.form.AuthorForm;
import com.coder.form.AuthorRegisterForm;
import com.coder.form.BookGroupForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.AuthorRegisterService;

@Controller
@Transactional
public class BookRegisterController {
	@Autowired
	private BookRegisterServic bookRegisterServic;
	@RequestMapping("/bookRegisterPath")
	public String TypeRegisterDispatcher(@ModelAttribute("typeRegisterForm")TypeRegisterForm typeRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		HttpSession session=req.getSession(true);	
	    BookRegisterForm bookRegisterForm=new BookRegisterForm();
		modelMap.addAttribute("bookRegisterForm",bookRegisterForm);
		bookRegisterServic.prepareBookRegister(bookRegisterForm);
		return "bookRegister";
	}
	
	
	
	@Autowired
    private AuthorRegisterService authorRegisterService;
	@RequestMapping("/addBookAuthorPath")
	public String AddBookAuthorDispatcher(@ModelAttribute("bookRegisterForm") BookRegisterForm bookRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		HttpSession session=req.getSession(true);	
		BookGroupForm bookGroupForm=(BookGroupForm) session.getAttribute("bookGroupForm");
		bookRegisterForm.getBookForm().setBookGroupId(bookGroupForm.getBookGroupId());

		bookRegisterServic.prepareBookRegister(bookRegisterForm);
		
	    ArrayList<AuthorForm> selectAuthorForms=new ArrayList<>();
	    session.setAttribute("bookForm",bookRegisterForm.getBookForm());
	    session.setAttribute("authorForms",selectAuthorForms);
	    AuthorRegisterForm  authorRegisterForm=new AuthorRegisterForm();
		this.authorRegisterService.prepareAuthorRegister(authorRegisterForm);
		modelMap.addAttribute("authorRegisterForm",authorRegisterForm);
		return "addBookAuthor";
	}
	
}
