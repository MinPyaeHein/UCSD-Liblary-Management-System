package com.coder.controller.teacher;
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
import com.coder.form.DepartmentRegisterForm;
import com.coder.form.StudentRegisterForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.DepartmentServic;
import com.coder.servic.StudentRegisterServic;
import com.coder.servic.TeacherServic;
import com.coder.servic.AuthorRegisterService;
@Controller
@Transactional
public class DepartmentController {
	@Autowired
	private DepartmentServic departmentServic;
	@RequestMapping("/departmentRegisterPath")
	public String departmentRegisterDispatcher(@ModelAttribute("departmentRegisterForm")DepartmentRegisterForm departmentRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		departmentRegisterForm=new DepartmentRegisterForm();
		modelMap.addAttribute("departmentRegisterForm",departmentRegisterForm);
		departmentServic.prepareDepartmentRegister(departmentRegisterForm);
		return "departmentRegister";
	}
	@RequestMapping("/departmentRegisterSubmitPath")
	public String departmentRegisterSubmitDispatcher(@ModelAttribute("departmentRegisterForm")DepartmentRegisterForm departmentRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		this.departmentServic.prepareDepartmentRegister(departmentRegisterForm);
		modelMap.addAttribute("departmentRegisterForm",departmentRegisterForm);
		return "departmentRegister";
	}
	
}
