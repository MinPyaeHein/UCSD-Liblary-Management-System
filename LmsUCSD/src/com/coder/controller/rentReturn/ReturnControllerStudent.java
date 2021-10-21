package com.coder.controller.rentReturn;
import java.text.ParseException;
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
import com.coder.form.AdminRegisterform;
import com.coder.form.LoginForm;
import com.coder.form.MessageForm;
import com.coder.form.RentReturnForm;
import com.coder.form.RentReturnRegisterForm;
import com.coder.form.RentReturnTeacherRegisterForm;
import com.coder.model.Login;
import com.coder.servic.AdminServic;
import com.coder.servic.LoginServic;
import com.coder.servic.RentReturnStudentServic;
import com.coder.servic.RentReturnTeacherServic;


@Controller
@Transactional
public class ReturnControllerStudent {
	
	@Autowired
	private LoginServic loginServic;
	@Autowired
	private AdminServic adminServic;
	@Autowired
	private RentReturnStudentServic rentReturnStudentServic;
	@Autowired
	private RentReturnTeacherServic rentReturnTeacherServic;
	@RequestMapping("/returnLoginPath")
	public String loginDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		LoginForm loginForm=new LoginForm();
		modelMap.addAttribute("loginForm",loginForm);
		return "returnLogin";
	}
	@RequestMapping("/returnloginSubmitPath")
	public String loginSubmitDispatcher(@ModelAttribute("LoginForm") LoginForm loginForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{	HttpSession session=req.getSession(true);	
	    Login loginObj=this.loginServic.testLogin(loginForm);
	    String exit=req.getParameter("exit");
		if(exit!=null){
			return "userHome";	
		}
	    if(loginObj!=null){
	        session.setAttribute("loginReturn",loginObj);
   		 if(loginObj.getUserId().startsWith("SID")){
   			 session.setAttribute("type","student");     
		    	 RentReturnRegisterForm rentReturnRegisterForm=new RentReturnRegisterForm();
		    	 rentReturnRegisterForm.setId(loginObj.getUserId());
		    	 this.rentReturnStudentServic.perparReturnBook1(rentReturnRegisterForm);
		    	 rentReturnRegisterForm.setTitle("Return Book For Student");
		    	 modelMap.addAttribute("rentReturnRegisterForm", rentReturnRegisterForm);
	    		 return "selectRentBook";
   		 }else if(loginObj.getUserId().startsWith("TID")){
   			 session.setAttribute("type","teacher"); 
   			 RentReturnRegisterForm rentReturnRegisterForm=new RentReturnRegisterForm();
	    	 rentReturnRegisterForm.setId(loginObj.getUserId());
	    	 this.rentReturnTeacherServic.perparReturnBook1(rentReturnRegisterForm);
	    	 rentReturnRegisterForm.setTitle("Return Book For Teacher");
	    	 modelMap.addAttribute("rentReturnRegisterForm", rentReturnRegisterForm);
    		 return "selectRentBook";
   		 }
	     }else{
       	        loginForm=new LoginForm();
       	        loginForm.setMessage("Incorrect User ID And Password!");
       			modelMap.addAttribute("loginForm",loginForm);
       	    	return "returnLogin";
        	      }
		return null;
    	     }
	@RequestMapping("/selectRentBookPath")
	public String selectRentbookDispatcher(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp)
	{
		HttpSession session=req.getSession(true);	
	    Login loginObj= (Login) session.getAttribute("loginReturn");
	    
	    if(loginObj!=null){
   		 if(loginObj.getUserId().startsWith("SID")){
   			 
   			     session.setAttribute("type","student"); 
		    	 RentReturnRegisterForm rentReturnRegisterForm=new RentReturnRegisterForm();
		    	 rentReturnRegisterForm.setId(loginObj.getUserId());
		    	 this.rentReturnStudentServic.perparReturnBook1(rentReturnRegisterForm);
		    	 rentReturnRegisterForm.setTitle("Return Book For Student");
		    	 modelMap.addAttribute("rentReturnRegisterForm", rentReturnRegisterForm);
	    		 return "selectRentBook";
	    		 
   		 }else if(loginObj.getUserId().startsWith("TID")){
   			 
   			 session.setAttribute("type","teacher"); 
   			 RentReturnRegisterForm rentReturnRegisterForm=new RentReturnRegisterForm();
	    	 rentReturnRegisterForm.setId(loginObj.getUserId());
	    	 this.rentReturnTeacherServic.perparReturnBook1(rentReturnRegisterForm);
	    	 rentReturnRegisterForm.setTitle("Return Book For Teacher");
	    	 modelMap.addAttribute("rentReturnRegisterForm", rentReturnRegisterForm);
    		 return "selectRentBook";
   		 }
   		 }
	    return "userHome"; 
    	     }
	@RequestMapping("/returnBookSubmitPath")
	public String returnBookSubmitDispatcher(@ModelAttribute("rentReturnStudentRegisterForm") RentReturnRegisterForm rentReturnRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp) throws ParseException
	{	
		HttpSession session=req.getSession(true);	
		String frmUserId=req.getParameter("frmUserId");
	    Login loginReturn= (Login) session.getAttribute("loginReturn");
	    Login loginObj= (Login) session.getAttribute("loginObj");
	    Login login= (Login) session.getAttribute("login");
	    
	    System.out.println("loginReturn="+loginReturn);
	    System.out.println("loginObj="+loginObj);
	    System.out.println("login="+login);
	    
	    if((loginReturn==null)&&(loginObj!=null)){
			  rentReturnRegisterForm.setTitle("forShow"); 
			  loginReturn=loginObj;
			  System.out.println("user");
		  }
	    if((loginReturn==null)&&(login!=null)){
	    	
			  rentReturnRegisterForm.setTitle("forShow"); 
			  loginReturn=login;
			  loginReturn.setUserId(frmUserId);
			  System.out.println("admin");
		  }
	    System.out.println("loginReturn2="+loginReturn);
	    if(loginReturn!=null){
	   		 if(loginReturn.getUserId().startsWith("SID")){
		          String rentId=req.getParameter("frmRentId");
		          System.out.println("rentId="+rentId);
	     		  rentReturnRegisterForm.setRentId(rentId);
	     		  MessageForm messageForm= this.rentReturnStudentServic.preparReturnBook2(rentReturnRegisterForm);
	     		  messageForm.setTitle("Return Result Student");
	     		  modelMap.addAttribute("messageForm", messageForm);
	
	   		 }else if(loginReturn.getUserId().startsWith("TID")){
    	    	  String rentId=req.getParameter("frmRentId");
  		          System.out.println("rentId="+rentId);
  	     		  rentReturnRegisterForm.setRentId(rentId);
  	     		  MessageForm messageForm= this.rentReturnTeacherServic.preparReturnBook2(rentReturnRegisterForm);
  	     		  messageForm.setTitle("Return Result Teacher");
  	     		  modelMap.addAttribute("messageForm", messageForm);
  		    	 
  	    		
    	     }
	    }
	    return "returnResult";
	    
	}
	
	@RequestMapping("/returnShowBookPath")
	public String returnBookShowDispatcher(@ModelAttribute("rentReturnStudentRegisterForm") RentReturnRegisterForm rentReturnRegisterForm,ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp) throws ParseException
	{	
		HttpSession session=req.getSession(true);
		String exit=req.getParameter("exit");
		String frmUserId=req.getParameter("frmUserId");
	  
	   
	   if(null==exit){
	   
	   		 if(frmUserId.startsWith("SID")){
		          String rentId=req.getParameter("frmRentId");
		        
	     		  rentReturnRegisterForm.setRentId(rentId);
	     		  MessageForm messageForm= this.rentReturnStudentServic.preparShowReturnBook(rentReturnRegisterForm);
	     		  messageForm.setTitle("Show Return Info Student");
	     		  modelMap.addAttribute("messageForm", messageForm);
	
	   		 }else if(frmUserId.startsWith("TID")){
    	    	  String rentId=req.getParameter("frmRentId");
  		         
  	     		  rentReturnRegisterForm.setRentId(rentId);
  	     		  MessageForm messageForm= this.rentReturnTeacherServic.preparShowReturnBookTea(rentReturnRegisterForm);
  	     		  messageForm.setTitle("Show Return Info Teacher ");
  	     		  modelMap.addAttribute("messageForm", messageForm);
  	    	   
    	     }
	    
	   	 return "returnResult"; 
	    
	}else{
		 return "userHome"; 
   			
	}
		
      }}
	
	

