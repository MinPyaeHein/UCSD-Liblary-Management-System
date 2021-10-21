package com.coder.controller.exal;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coder.exalForm.ExalDowloadForm;
import com.coder.exalForm.ExpExalViewForm;
import com.coder.exalServic.ExalDowloadServic;
import com.coder.exalServic.ExpRentByGreadServic;

@Controller
@Transactional
public class ExportExalRentByGradeController {
	@Autowired
	private ExpRentByGreadServic expRentByGreadServic;
		
	@RequestMapping("/expRentByGradePath")
	public String expRentByGreadDispatcher(HttpServletRequest req,HttpServletResponse resp,ModelMap modelMap) throws FileNotFoundException, IOException
	{   ExpExalViewForm expExalViewForm=new ExpExalViewForm();
		expRentByGreadServic.prepaerRentByGread(expExalViewForm);
		modelMap.addAttribute("expExalViewForm", expExalViewForm);
		return "exportExal";
	}
	@RequestMapping("/expRentByGradeSubmitPath")
	public String expRentByGreadSubmitDispatcher(@ModelAttribute("expExalViewForm") ExpExalViewForm expExalViewForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws FileNotFoundException, IOException
	{   expExalViewForm.setRequest(req);
	    expExalViewForm.setResponse(resp);
	    HttpSession session=req.getSession(true);	
		int id=-1;
		ExalDowloadForm exalDowloadForm=new ExalDowloadForm();
		 exalDowloadForm.setPath("expRentByGradePath");
		 exalDowloadForm.setTypeId(expExalViewForm.getExalTypeId());
	    session.setAttribute("exalDowloadForm",exalDowloadForm);
	    expRentByGreadServic.expRentByGread(expExalViewForm);
		  
	    
		expRentByGreadServic.prepaerRentByGread(expExalViewForm);
		modelMap.addAttribute("expExalViewForm", expExalViewForm);
		
		return "exportExal";
	}
	
	
	
	
}
