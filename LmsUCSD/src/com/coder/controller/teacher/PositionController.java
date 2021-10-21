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
import com.coder.form.PositionRegisterForm;
import com.coder.form.StudentRegisterForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.DepartmentServic;
import com.coder.servic.PositionServic;
import com.coder.servic.StudentRegisterServic;
import com.coder.servic.TeacherServic;
import com.coder.servic.AuthorRegisterService;
@Controller
@Transactional
public class PositionController {
	@Autowired
	private PositionServic positionServic;
	@RequestMapping("/positionRegisterPath")
	public String positionRegisterDispatcher(@ModelAttribute("positionRegisterForm")PositionRegisterForm positionRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		positionRegisterForm=new PositionRegisterForm();
		modelMap.addAttribute("positionRegisterForm",positionRegisterForm);
		positionServic.preparePositionRegister(positionRegisterForm);
		return "positionRegister";
	}
	@RequestMapping("/positionRegisterSubmitPath")
	public String positionRegisterSubmitDispatcher(@ModelAttribute("positionRegisterForm")PositionRegisterForm positionRegisterForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		this.positionServic.preparePositionRegister(positionRegisterForm);
		modelMap.addAttribute("positionRegisterForm",positionRegisterForm);
		return "positionRegister";
	}
	
}
