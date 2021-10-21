package com.coder.controller.book;



import java.util.ArrayList;

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
import com.coder.form.BookForm;
import com.coder.form.BookGroupForm;
import com.coder.form.SaveBookConfrimForm;
import com.coder.form.ShellForm;
import com.coder.form.ShellRegisterForm;
import com.coder.form.TypeForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.SaveBookConfrimServic;




@Controller
@Transactional
public class SaveBookConfrimController {
@Autowired
private SaveBookConfrimServic saveBookConfrimServic;
	
	@RequestMapping("/saveBookConfrimSubmitPath")
	public String bookShellRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		String save=req.getParameter("save");
		
	    String cancle=req.getParameter("cancle");
	    SaveBookConfrimForm saveBookConfrimForm=new SaveBookConfrimForm();
	    
		if(save!=null){
			
			 HttpSession session=req.getSession(true);	
			 
			 ArrayList<AuthorForm> authorForms=( ArrayList<AuthorForm>) session.getAttribute("authorForms");
			 ArrayList<ShellForm> shellForms=( ArrayList<ShellForm>) session.getAttribute("shellForms");
			 ArrayList<TypeForm> typeForms=( ArrayList<TypeForm>) session.getAttribute("typeForms");
			 
			 BookForm bookForm=(BookForm) session.getAttribute("bookForm");
			 saveBookConfrimForm.setAuthorForms(authorForms);
			 saveBookConfrimForm.setShellForms(shellForms);
			 saveBookConfrimForm.setTypeForms(typeForms);
			 saveBookConfrimForm.setBookId(bookForm.getBookId());
			 saveBookConfrimServic.prepareSaveBookConfrim(saveBookConfrimForm);
			 modelMap.addAttribute("saveBookConfrimForm",saveBookConfrimForm);
	     return "showAllBook";
	     
	     }else if(cancle!=null){
	    	 
	     return "userHome";
	     }else{
	    	saveBookConfrimServic.prepareSaveBookConfrim(saveBookConfrimForm);
	        modelMap.addAttribute("saveBookConfrimForm",saveBookConfrimForm);
	     return "showAllBook";
	     }
			
		
	}
	@RequestMapping("/sbcDeleteBookAuthorSubmitPath")
	public String deleteBookAuthorSubmitDispatcher(@ModelAttribute("authorRegisterForm") AuthorRegisterForm authorRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
	    String frmAuthorId=req.getParameter("frmAuthorId");
	 
	    
	    HttpSession session=req.getSession(true);	
	    ArrayList<AuthorForm> authorForms=( ArrayList<AuthorForm>) session.getAttribute("authorForms");
	    int i=0;
	   for(AuthorForm at:authorForms){
	   if(at.getAuthorId().equals(frmAuthorId)){
			   authorForms.remove(i);
			   break;
		   }
		   i++;	   }
	    
	    session.setAttribute("authorForms",authorForms);
	    
		return "saveBookConfrim";
		
	
	}
	@RequestMapping("/sbcDeleteBookShellSubmitPath")
	public String deleteBookShellSubmitDispatcher(@ModelAttribute("shellRegisterForm") ShellRegisterForm shellRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
	    String frmShellId=req.getParameter("frmShellId");
	 
	    
	    HttpSession session=req.getSession(true);	
	    ArrayList<ShellForm> shellForms=( ArrayList<ShellForm>) session.getAttribute("shellForms");
	    int i=0;
	   for(ShellForm at:shellForms){
		  
		   if(at.getShellId().equals(frmShellId)){
			   shellForms.remove(i);
			   break;
		   }
		   i++; }
	    
	    session.setAttribute("shellForms",shellForms);
	
		
		return "saveBookConfrim";
		
	
	}
	@RequestMapping("/sbcDeleteBookTypeSubmitPath")
	public String DeleteBookTypeSubmitDispatcher( ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
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
		
		return "saveBookConfrim";
		}
	
}
