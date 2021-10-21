package com.coder.controller.admin;
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
import com.coder.form.MemberRegisterForm;
import com.coder.form.RoleRegisterForm;
import com.coder.form.StudentRegisterForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.MemberServic;
import com.coder.servic.RoleServic;
import com.coder.servic.StudentRegisterServic;
import com.coder.servic.TeacherServic;
import com.coder.servic.AuthorRegisterService;
@Controller
@Transactional
public class RoleController {
	@Autowired
	private RoleServic roleServic;
	@RequestMapping("/roleRegisterPath")
	public String roleRegisterDispatcher(@ModelAttribute("roleRegisterForm")RoleRegisterForm roleRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		roleRegisterForm=new RoleRegisterForm();
		modelMap.addAttribute("roleRegisterForm",roleRegisterForm);
		this.roleServic.prepareRoleRegister(roleRegisterForm);
		return "roleRegister";
	}
	@RequestMapping("/roleRegisterSubmitPath")
	public String roleRegisterSubmitDispatcher(@ModelAttribute("roleRegisterForm")RoleRegisterForm roleRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		String save=req.getParameter("save");
		String exit=req.getParameter("exit");
		if(save!=null){
		this.roleServic.prepareRoleRegister(roleRegisterForm);
		modelMap.addAttribute("roleRegisterForm",roleRegisterForm);
		
		return "roleRegister";
		}else {
	    return "userHome";	
		}
		
	}
	
}
