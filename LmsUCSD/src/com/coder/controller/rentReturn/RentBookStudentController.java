package com.coder.controller.rentReturn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.coder.form.LoginForm;
import com.coder.form.RentReturnForm;
import com.coder.form.RentReturnRegisterForm;
import com.coder.form.RentReturnTeacherForm;
import com.coder.form.RentReturnTeacherRegisterForm;
import com.coder.model.Login;
import com.coder.servic.LoginServic;
import com.coder.servic.RentReturnStudentServic;
import com.coder.servic.RentReturnTeacherServic;


@Controller
@Transactional
public class RentBookStudentController {
	@Autowired
	private RentReturnTeacherServic rentReturnTeacherServic;
	@Autowired
	private LoginServic loginServic;
	@Autowired
	private RentReturnStudentServic rentReturnStudentServic;
	@RequestMapping("/rentBookLoginPath")
	public String rentBookDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		LoginForm loginForm=new LoginForm();
		modelMap.addAttribute("loginForm",loginForm);
	
		return "rentLogin";
	}
	@RequestMapping("/rentBookLoginSubmitPath")
	public String rentBookSubmitDispatcher(@ModelAttribute("LoginForm") LoginForm loginForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		     HttpSession session=req.getSession(true);	
	    	 Login loginObj=this.loginServic.testLogin(loginForm);
	    	 RentReturnRegisterForm rentReturnRegisterForm=new RentReturnRegisterForm();
	    		String exit=req.getParameter("exit");
	    		if(exit!=null){
	    			return "userHome";	
	    		}
	    		 if(loginObj!=null){
	    		 if(loginObj.getUserId().startsWith("SID")){
	    			 session.setAttribute("userId",loginObj.getUserId()); 
	    			 session.setAttribute("type","student"); 
	    			 rentReturnStudentServic.prepareRentReturnStudentRegister(rentReturnRegisterForm);
	    			 RentReturnForm rentReturnForm= rentReturnRegisterForm.getRentReturnForm();
	    			 rentReturnForm.setUserId(loginObj.getUserId());
	    			 rentReturnRegisterForm.setRentReturnForm(rentReturnForm);
	    			 rentReturnRegisterForm.setTitle("Rent Book For Student");
	    			 modelMap.addAttribute("rentReturnRegisterForm",rentReturnRegisterForm);
	    			 return "rentBook";
	    			 
	    		 }else{
	    			 session.setAttribute("userId",loginObj.getUserId()); 
	    			 session.setAttribute("type","teacher"); 
	    	 		
	    	 		 rentReturnTeacherServic.prepareRentReturnTeacherRegister(rentReturnRegisterForm);
	    	 		 RentReturnForm rentReturnForm= rentReturnRegisterForm.getRentReturnForm();
	    	 		 rentReturnForm.setUserId(loginObj.getUserId());
	    	 		 rentReturnRegisterForm.setRentReturnForm(rentReturnForm);
	    	 		 rentReturnRegisterForm.setTitle("Rent Book For Teacher");
	    	 		 modelMap.addAttribute("rentReturnRegisterForm",rentReturnRegisterForm);
	    	 		
	    			  return "rentBook";
	    		 }
	    		 }else{
    	        loginForm=new LoginForm();
    	        loginForm.setMessage("Incorrect User ID And Password!");
    			modelMap.addAttribute("loginForm",loginForm);
    	    	return "rentLogin";
	    	      }
     	      
	}
	
	@RequestMapping("/rentBookSubmitPath")
	public String rentBookSubmitDispatcher(@ModelAttribute("rentReturnRegisterForm")RentReturnRegisterForm rentReturnRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{
		HttpSession session=req.getSession(true);	
		Login login=(Login) session.getAttribute("login");
		String type=(String)session.getAttribute("type");
		if(type.equals("student")){
			RentReturnForm rentReturnForm=rentReturnRegisterForm.getRentReturnForm();
			System.out.println("adminId="+login.getUserId());
			rentReturnForm.setAdminId(login.getUserId());
			rentReturnStudentServic.prepareRentReturnStudentRegister(rentReturnRegisterForm);
		    String result=rentReturnRegisterForm.getMessage();
			String userId=(String) session.getAttribute("userId");
			rentReturnForm.setUserId(userId);
			 rentReturnRegisterForm.setTitle("Rent Book For Student");
			rentReturnRegisterForm.setRentReturnForm(rentReturnForm);
			if(result==null){
			rentReturnRegisterForm.setMessage("Succeed Rent Process!");
			}else{
			rentReturnRegisterForm.setMessage(result);	
			}
			modelMap.addAttribute("rentReturnRegisterForm",rentReturnRegisterForm);
		    return "rentBook";
		}else{
			RentReturnForm rentReturnForm=rentReturnRegisterForm.getRentReturnForm();
			rentReturnForm.setAdminId(login.getUserId());
			rentReturnTeacherServic.prepareRentReturnTeacherRegister(rentReturnRegisterForm);
		    String result=rentReturnRegisterForm.getMessage();
			String userId=(String) session.getAttribute("userId");
			rentReturnForm.setUserId(userId);
			 rentReturnRegisterForm.setTitle("Rent Book For Teacher");
			rentReturnRegisterForm.setRentReturnForm(rentReturnForm);
			if(result==null){
				rentReturnRegisterForm.setMessage("Succeed Rent Process!");
			}else{
				rentReturnRegisterForm.setMessage(result);	
			}
			modelMap.addAttribute("rentReturnRegisterForm",rentReturnRegisterForm);
		    return "rentBook";
		}
	}
	
	@RequestMapping("/showAllReturnPath")
	public String showAllReturnDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{RentReturnRegisterForm returnStudentRegisterForm=new RentReturnRegisterForm();
		this.rentReturnStudentServic.showAllReturnList(returnStudentRegisterForm);
		modelMap.addAttribute("returnStudentRegisterForm", returnStudentRegisterForm);
		return "showAllReturnStudent";
	}
	@RequestMapping("/showAllRentPath")
	public String showAllRentDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{RentReturnRegisterForm returnStudentRegisterForm=new RentReturnRegisterForm();
		this.rentReturnStudentServic.showAllRentList(returnStudentRegisterForm);
		modelMap.addAttribute("returnStudentRegisterForm", returnStudentRegisterForm);
		return "showAllRentStudent";
	}
	
	
	
}
