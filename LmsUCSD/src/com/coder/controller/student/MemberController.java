package com.coder.controller.student;
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
import com.coder.form.StudentRegisterForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.MemberServic;
import com.coder.servic.StudentRegisterServic;
import com.coder.servic.TeacherServic;
import com.coder.servic.AuthorRegisterService;
@Controller
@Transactional
public class MemberController {
	@Autowired
	private MemberServic memberServic;
	@RequestMapping("/memberRegisterPath")
	public String memberRegisterDispatcher(@ModelAttribute("memberRegisterForm")MemberRegisterForm memberRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		memberRegisterForm=new MemberRegisterForm();
		modelMap.addAttribute("memberRegisterForm",memberRegisterForm);
		memberServic.prepareMemberRegister(memberRegisterForm);
		return "memberRegister";
	}
	@RequestMapping("/memberRegisterSubmitPath")
	public String studentRegisterSubmitDispatcher(@ModelAttribute("memberRegisterForm")MemberRegisterForm memberRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   String finish=req.getParameter("finish");
	    String save=req.getParameter("save");
	    if(save!=null){
		this.memberServic.prepareMemberRegister(memberRegisterForm);
		modelMap.addAttribute("memberRegisterForm",memberRegisterForm);
		return "memberRegister";
		
	    }else{
	    	return "userHome";	
	    }
	}
	
}
