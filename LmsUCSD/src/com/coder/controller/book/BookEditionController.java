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
import com.coder.form.BookRegisterForm;
import com.coder.form.BookEditionRegisterFrom;
import com.coder.form.MemberRegisterForm;
import com.coder.form.StudentRegisterForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.MemberServic;
import com.coder.servic.StudentRegisterServic;
import com.coder.servic.TeacherServic;
import com.coder.servic.AuthorRegisterService;
import com.coder.servic.BookEditionServic;
@Controller
@Transactional
public class BookEditionController {
	@Autowired
	private BookEditionServic bookEditionServic;
	@RequestMapping("/bookEditionRegisterPath")
	public String memberRegisterDispatcher(@ModelAttribute("bookEditionRegisterFrom")BookEditionRegisterFrom bookEditionRegisterFrom,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   System.out.println("bookEditionRegister");
		bookEditionRegisterFrom=new BookEditionRegisterFrom();
		
		bookEditionServic.prepareBookEditionRegister(bookEditionRegisterFrom);
		modelMap.addAttribute("bookEditionRegisterFrom",bookEditionRegisterFrom);
		System.out.println(".getBookEditions().size()="+bookEditionRegisterFrom.getBookEditions().size());
		return "editionRegister";
	}
	@RequestMapping("/bookEditionRegisterSubmitPath")
	public String studentRegisterSubmitDispatcher(@ModelAttribute("bookEditionRegisterFrom")BookEditionRegisterFrom bookEditionRegisterFrom,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   String save=req.getParameter("save");
        String exit=req.getParameter("exit");
        if(save!=null){
		this.bookEditionServic.prepareBookEditionRegister(bookEditionRegisterFrom);
		modelMap.addAttribute("bookEditionRegisterFrom",bookEditionRegisterFrom);
		return "editionRegister";
        }else{
        	return "userHome";
        }
	}
	
}
