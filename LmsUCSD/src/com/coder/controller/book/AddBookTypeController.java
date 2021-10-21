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
import com.coder.form.BookGroupForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.TypeForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.TypeRegisterServic;


@Controller
@Transactional
public class AddBookTypeController {
	@Autowired
	private BookRegisterServic bookRegisterServic;
	@Autowired
	private TypeRegisterServic typeRegisterServic;
	
	@RequestMapping("/typeRegisterSubmitPath")
	public String bookTypeRegisterSubmitDispatcher(@ModelAttribute("typeRegisterForm") TypeRegisterForm typeRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		
		 HttpSession session=req.getSession(true);	
		 BookGroupForm bookGroupForm=(BookGroupForm) session.getAttribute("bookGroupForm");
		 typeRegisterForm.setBookGroupId(bookGroupForm.getBookGroupId());
		 typeRegisterServic.prepareTypeRegister(typeRegisterForm);
		 
		 ArrayList<TypeForm> typeForms=( ArrayList<TypeForm>) session.getAttribute("typeForms");
		 session.setAttribute("typeForms",typeForms);
		 modelMap.addAttribute("typeRegisterForm",typeRegisterForm);
	 
			return "addBookType";
		
		
	}
	
	@RequestMapping("/addBookTypeSubmitPath")
	public String AddBookTypeSubmitDispatcher(@ModelAttribute("typeRegisterForm") TypeRegisterForm typeRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
	    String frmTypeId=req.getParameter("frmTypeId");
	    
	    
	    HttpSession session=req.getSession(true);	
	    ArrayList<TypeForm> typeForms=( ArrayList<TypeForm>) session.getAttribute("typeForms");
	    BookGroupForm bookGroupForm=(BookGroupForm) session.getAttribute("bookGroupForm");
	
		 
	   TypeForm typeForm=new TypeForm();
	   typeForm.setTypeId(frmTypeId);
	   typeRegisterForm.setTypeForm(typeForm);
	   
		typeRegisterForm.setBookGroupId(bookGroupForm.getBookGroupId());
		typeRegisterServic.prepareTypeRegister(typeRegisterForm);
		typeForms.add(typeRegisterForm.getTypeForm());
	    session.setAttribute("typeForms",typeForms);
	    
		modelMap.addAttribute("typeRegisterForm",typeRegisterForm);
		
		
		return "addBookType";
		
	
	}
	@RequestMapping("/deleteBookTypeSubmitPath")
	public String DeleteBookTypeSubmitDispatcher(@ModelAttribute("typeRegisterForm") TypeRegisterForm typeRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
	    String frmTypeId=req.getParameter("frmTypeId");
	    HttpSession session=req.getSession(true);	
	    ArrayList<TypeForm> typeForms=( ArrayList<TypeForm>) session.getAttribute("typeForms");
	    int i=0;
	    for(TypeForm tp:typeForms){
		  if(tp.getTypeId().equals(frmTypeId)){
			typeForms.remove(i); 
			break;
		  }
		  i++;
		   }
	    session.setAttribute("typeForms",typeForms);
	    BookGroupForm bookGroupForm=(BookGroupForm) session.getAttribute("bookGroupForm");
		typeRegisterForm=new TypeRegisterForm();
		
		typeRegisterForm.setBookGroupId(bookGroupForm.getBookGroupId());
		typeRegisterServic.prepareTypeRegister(typeRegisterForm);
		modelMap.addAttribute("typeRegisterForm",typeRegisterForm);
		return "addBookType";
		}
	
	@RequestMapping("/goToBookRegisterPath")
	public String bookRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		String exit=req.getParameter("exit");
	    String next=req.getParameter("next");
		if(next!=null){
		BookRegisterForm bookRegisterForm=new BookRegisterForm();
		 modelMap.addAttribute("bookRegisterForm",bookRegisterForm);
	   	bookRegisterServic.prepareBookRegister(bookRegisterForm);
	   	
	     return "bookRegister";
	     }else{
	     return "home";
	     }
			
		
	}
	
}
