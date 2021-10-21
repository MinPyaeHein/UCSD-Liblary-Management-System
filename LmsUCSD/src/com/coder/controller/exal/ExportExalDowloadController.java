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
public class ExportExalDowloadController {
	@Autowired
	private ExpRentByGreadServic expRentByGreadServic;
	@Autowired
	private ExalDowloadServic exalDowloadServic;
	
		
	@RequestMapping("/expDowloadPath")
	public String expDowloadDispatcher(@ModelAttribute("expExalViewForm") ExpExalViewForm expExalViewForm,ModelMap modelMap,HttpServletRequest req,HttpServletResponse resp) throws FileNotFoundException, IOException
	{   expExalViewForm.setRequest(req);
	    expExalViewForm.setResponse(resp);
	    HttpSession session=req.getSession(true);	
		ExalDowloadForm exalDowloadForm=(ExalDowloadForm) session.getAttribute("exalDowloadForm");
		int id=Integer.parseInt(exalDowloadForm.getTypeId());
		String path=exalDowloadForm.getPath();
		if(path.equals("expRentByGradePath")){
		if(id==1){
			exalDowloadServic.doDownload(req, resp, "/META-INF/pieChartRentListByGrade.xlsx");
		}else if(id==2){
			exalDowloadServic.doDownload(req, resp, "/META-INF/LineAndBarChartRentByGrade.xlsx");
		}else if(id==3){
			exalDowloadServic.doDownload(req, resp, "/META-INF/BarChartRentListByGrade.xlsx");
		}else if(id==4){
			exalDowloadServic.doDownload(req, resp, "/META-INF/BarChartStudentListByGrade.xlsx");
		}else if(id==5){
			exalDowloadServic.doDownload(req, resp, "/META-INF/BarChartRentListByGender.xlsx");
		}
		
		    expExalViewForm=new ExpExalViewForm();
			expRentByGreadServic.prepaerRentByGread(expExalViewForm);
			modelMap.addAttribute("expExalViewForm", expExalViewForm);
			return "exportExal";
		
		}else if(path.equals("expRentByGroupPath")){
			if(id==1){
				exalDowloadServic.doDownload(req, resp, "/META-INF/pieChartBookListByGroup.xlsx");
			}else if(id==2){
				exalDowloadServic.doDownload(req, resp, "/META-INF/LineAndBarChartRentByGroup.xlsx");
				
			}else if(id==3){
				exalDowloadServic.doDownload(req, resp, "/META-INF/BarChartBookListByGroup.xlsx");
			}
			
		}
		//expRentByGreadServic.prepaerRentByGread(expExalViewForm);
		//modelMap.addAttribute("expExalViewForm", expExalViewForm);
		
		return "exportExal";
	}
	
	
}
