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
import com.coder.form.ShellForm;
import com.coder.form.ShellRegisterForm;
import com.coder.servic.AuthorRegisterService;
import com.coder.servic.ShellRegisterServic;


@Controller
@Transactional
public class AddBookAuthorController {
	@Autowired
	private ShellRegisterServic shellRegisterServic;
	
	@Autowired
	private AuthorRegisterService authorRegisterService;
	@RequestMapping("/authorRegisterSubmitPath")
	public String userRegisterSubmitDispatcher(@ModelAttribute("authorRegisterForm") AuthorRegisterForm authorRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		 HttpSession session=req.getSession(true);	
		 this.authorRegisterService.prepareAuthorRegister(authorRegisterForm);
		 ArrayList<AuthorForm> authorForms=( ArrayList<AuthorForm>) session.getAttribute("authorForms");
		 session.setAttribute("authorForms",authorForms);
		 
	     
	     modelMap.addAttribute("authorRegisterForm",authorRegisterForm);
	 
			return "addBookAuthor";
		
		
	}
	
	@RequestMapping("/addBookAuthorSubmitPath")
	public String AddBookAuthorSubmitDispatcher(@ModelAttribute("authorRegisterForm") AuthorRegisterForm authorRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
	    String frmAuthorId=req.getParameter("frmAuthorId");
	    HttpSession session=req.getSession(true);	
	    ArrayList<AuthorForm> authorForms=( ArrayList<AuthorForm>) session.getAttribute("authorForms");
	    authorRegisterForm=new AuthorRegisterForm();
	    AuthorForm authorForm=new AuthorForm();
	    authorForm.setAuthorId(frmAuthorId);
	    authorRegisterForm.setAuthorForm(authorForm);
	   
		this.authorRegisterService.prepareAuthorRegister(authorRegisterForm);
    	authorForms.add(authorRegisterForm.getAuthorForm());
	    session.setAttribute("authorForms",authorForms);
	    authorForm=null;
	    authorRegisterForm.setAuthorForm(authorForm);
	    modelMap.addAttribute("authorRegisterForm",authorRegisterForm);
		
		
		return "addBookAuthor";
		
	
	}
	@RequestMapping("/deleteBookAuthorSubmitPath")
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
	    authorRegisterForm=new AuthorRegisterForm();
		this.authorRegisterService.prepareAuthorRegister(authorRegisterForm);
		modelMap.addAttribute("authorRegisterForm",authorRegisterForm);
		
		return "addBookAuthor";
		
	
	}
	@RequestMapping("/goToBookShellPath")
	public String bookShellRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		String exit=req.getParameter("exit");
	    String next=req.getParameter("next");
		if(next!=null){
			HttpSession session=req.getSession(true);	
		    ArrayList<ShellForm> shellForms=new ArrayList<>();
		    session.setAttribute("shellForms", shellForms);
		    ShellRegisterForm shellRegisterForm=new ShellRegisterForm();
	    	shellRegisterServic.prepareShellRegister(shellRegisterForm);
		 modelMap.addAttribute("shellRegisterForm",shellRegisterForm);
	     return "addBookShell";
	     }else{
	     return "home";
	     }
			
		
	}
	
}
