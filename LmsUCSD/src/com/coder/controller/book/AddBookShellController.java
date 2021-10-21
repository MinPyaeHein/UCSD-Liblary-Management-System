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
import com.coder.form.ShellForm;
import com.coder.form.ShellRegisterForm;
import com.coder.servic.ShellRegisterServic;


@Controller
@Transactional
public class AddBookShellController {
	@Autowired
	private ShellRegisterServic shellRegisterServic;
	@RequestMapping("/shellRegisterSubmitPath")
	public String shellRegisterSubmitDispatcher(@ModelAttribute("shellRegisterForm") ShellRegisterForm shellRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	
		
		 HttpSession session=req.getSession(true);	
		 
		
		 shellRegisterServic.prepareShellRegister(shellRegisterForm);
		 
		 ArrayList<ShellForm> shellForms=( ArrayList<ShellForm>) session.getAttribute("shellForms");
		shellRegisterForm.setShellForms(shellForms);
		
	    modelMap.addAttribute("shellRegisterForm",shellRegisterForm);
	 
			return "addBookShell";
		
		
	}
	
	@RequestMapping("/addBookShellSubmitPath")
	public String AddBookShellSubmitDispatcher(@ModelAttribute("shellRegisterForm") ShellRegisterForm shellRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{	
	    String frmShellId=req.getParameter("frmShellId");
	   
	    
	    HttpSession session=req.getSession(true);	
	    ArrayList<ShellForm> shellForms=( ArrayList<ShellForm>) session.getAttribute("shellForms");
	  
	    ShellForm shellForm=new ShellForm();
	    shellForm.setShellId(frmShellId);
	    shellRegisterForm.setShellForm(shellForm);
	    shellRegisterServic.prepareShellRegister(shellRegisterForm);
	    shellForms.add(shellRegisterForm.getShellForm());
	    session.setAttribute("shellForms",shellForms);
	    shellForm=null;
	    shellRegisterForm.setShellForm(shellForm);
	   	modelMap.addAttribute("shellRegisterForm",shellRegisterForm);
		
		
		return "addBookShell";
		
	
	}
	@RequestMapping("/deleteBookShellSubmitPath")
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
		   i++;
		  
		  
	   }
	    
	    session.setAttribute("shellForms",shellForms);
	    
		this.shellRegisterServic.prepareShellRegister(shellRegisterForm);
		modelMap.addAttribute("shellRegisterForm",shellRegisterForm);
		
		return "addBookShell";
		
	
	}
	@RequestMapping("/goToSaveBookConfrimPath")
	public String goToSaveBookConfrimDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{ 
		String exit=req.getParameter("exit");
	    String next=req.getParameter("next");
		if(next!=null){
			
	   	
	     return "saveBookConfrim";
	     }else{
	     return "home";
	     }
			
		
	}
	
}
