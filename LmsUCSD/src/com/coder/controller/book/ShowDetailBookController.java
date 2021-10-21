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
import com.coder.form.BookRegisterForm;
import com.coder.form.SaveBookConfrimForm;
import com.coder.form.TypeRegisterForm;
import com.coder.servic.BookRegisterServic;
import com.coder.servic.SaveBookConfrimServic;
import com.coder.servic.AuthorRegisterService;

@Controller
@Transactional
public class ShowDetailBookController {
	@Autowired
	private SaveBookConfrimServic saveBookConfrimServic;
	@RequestMapping("/bookShowDetailSubmitPath")
	public String TypeRegisterDispatcher(ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp)
	{   
		 String frmBookId=req.getParameter("frmBookId");
		SaveBookConfrimForm saveBookConfrimForm=new SaveBookConfrimForm();
		saveBookConfrimForm.setBookId(frmBookId);
		
		modelMap.addAttribute("saveBookConfrimForm",saveBookConfrimForm);
		saveBookConfrimServic.prepareShowBookDetail(saveBookConfrimForm);
		return "showDetailBook";
       
	}
	
	
	
	
	
}
