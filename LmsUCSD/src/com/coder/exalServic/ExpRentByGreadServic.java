       package com.coder.exalServic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.coder.dao.GreadDao;
import com.coder.dao.SelectQuerryDao;
import com.coder.dao.StudentDao;
import com.coder.exal.ExalToBarAndLineChart;
import com.coder.exal.ExalToBarChart;
import com.coder.exal.ExalToPieChart;
import com.coder.exalForm.BarChartComFrom;
import com.coder.exalForm.BarChartForm;
import com.coder.exalForm.ExpExalViewForm;
import com.coder.exalForm.LineChartComForm;
import com.coder.exalForm.LineChartForm;
import com.coder.exalForm.PieChartComForm;
import com.coder.exalForm.PieChartForm;
import com.coder.model.Gread;
import com.coder.model.Student;

@Service
@Repository("expRentByGreadServic")
public class ExpRentByGreadServic {
@Autowired
private ExalDowloadServic exalDowloadServic;
@Autowired
private StudentDao StudentDao;
@Autowired
private GreadDao greadDao;
@Autowired
private SelectQuerryDao selectQuerryDao;
@Autowired
private ExalToBarChart exalToBarChart;
@Autowired
private ExalToPieChart exalToPieChart;
@Autowired
private ExalToBarAndLineChart exalToBarAndLineChart;

public void prepaerRentByGread(ExpExalViewForm expExalViewForm){
	expExalViewForm.setPath("expRentByGradeSubmitPath");
	expExalViewForm.setTitle("Export Excel Rent  By Grade");
	expExalViewForm.getMapExalTypes().put("1","Pie Chart Rent List By Grade");
	expExalViewForm.getMapExalTypes().put("2","Bar and Line Char Rent List By Grade");
	expExalViewForm.getMapExalTypes().put("3","Bar Chart Rent List By Grade");
	expExalViewForm.getMapExalTypes().put("4","Bar Chart Student By Grade ");
	expExalViewForm.getMapExalTypes().put("5","Bar Chart Student By Gender ");
	
}
public void expRentByGread(ExpExalViewForm expExalViewForm) throws FileNotFoundException, IOException{
	
	
	if(expExalViewForm.getExalTypeId()!=null){
	int id=Integer.parseInt(expExalViewForm.getExalTypeId().trim());
	if(id==1){
		expPieChart(expExalViewForm.getRequest());
	}else if(id==2){
		expBarAndLineChart(expExalViewForm.getResponse(),expExalViewForm.getRequest());
	}else if(id==3){
		expBarChart(expExalViewForm.getRequest());
	}else if(id==4){
		expBarChartStu(expExalViewForm.getRequest());
	}else if(id==5){
		expBarChartBySex(expExalViewForm.getRequest());
	}
}}
public void expPieChart(HttpServletRequest requ) throws IOException{
	 ServletContext context = requ.getServletContext();
     
     String appPath = context.getRealPath("");
 
	List<PieChartForm> piChartForms=new ArrayList<>();
	List<Gread> greads=greadDao.getGreads();
	for(Gread gd:greads){
	List<Student> students=this.selectQuerryDao.getRentByGread(gd);
	PieChartForm piChartForm=new PieChartForm();
	piChartForm.setName(gd.getGreadName());
	if(students==null){
		piChartForm.setValue(0);
	}else{
		piChartForm.setValue(students.size());
	}
	piChartForms.add(piChartForm);
	}
	PieChartComForm pieChartComForm=new PieChartComForm();
	pieChartComForm.setFileName("pieChartRentListByGrade");
	pieChartComForm.setTitle("Rent Data By Grade\nComparison of Student Grade in Rent Data");
	pieChartComForm.setPieChartForms(piChartForms);
	exalToPieChart.pieChart(pieChartComForm,appPath);
}

public void expBarAndLineChart(HttpServletResponse resp,HttpServletRequest requ) throws IOException{
	 ServletContext context = requ.getServletContext();
	                         
     String appPath = context.getRealPath("");
   
	List<LineChartForm> lineChartForms=new ArrayList<>();
	List<Gread> greads=greadDao.getGreads();
	for(Gread gd:greads){
	List<Student> studentsByGd=this.selectQuerryDao.getStudentByGread(gd);
	List<Student> students=this.selectQuerryDao.getRentByGread(gd);
	LineChartForm lineChartForm=new LineChartForm();
	if(studentsByGd==null){
		lineChartForm.setBarValue(0);
	}else{
		lineChartForm.setBarValue(studentsByGd.size());
	}
	if(students==null){
		lineChartForm.setLineValue(0);	
	}else{
		lineChartForm.setLineValue(students.size());
	}
	lineChartForm.setName(gd.getGreadName());
    lineChartForms.add(lineChartForm);
	}
	LineChartComForm lineChartComForm=new LineChartComForm();
	lineChartComForm.setLineChartForms(lineChartForms);
	lineChartComForm.setBarName("Student");
	lineChartComForm.setLineName("RentList");
	lineChartComForm.setFileName("LineAndBarChartRentByGrade");
	lineChartComForm.setTitle("Analysis Of the relation between Student Grade and Rent Data");
	exalToBarAndLineChart.barAndLineChart(lineChartComForm,resp,requ);
}
public void expBarChart(HttpServletRequest request) throws IOException{
	  ServletContext context = request.getServletContext();
      String appPath = context.getRealPath("");
 	List<BarChartForm> barChartForms=new ArrayList<>();
	List<Gread> greads=greadDao.getGreads();
	for(Gread gd:greads){
	List<Student> students=this.selectQuerryDao.getRentByGread(gd);
	
	BarChartForm barChartForm=new BarChartForm();
	barChartForm.setName(gd.getGreadName());

	if(students==null){
		barChartForm.setValue(0);
	}else{
		barChartForm.setValue(students.size());
	}
	barChartForms.add(barChartForm);
	}
	BarChartComFrom barChartComFrom=new BarChartComFrom();
	barChartComFrom.setFileName("BarChartRentListByGrade");
	barChartComFrom.setTitle("Rent Data By Grade\nComparison of Student Grade in Rent Data");
	barChartComFrom.setHorizontal("Grade Name");
	barChartComFrom.setVertical("Rent Data");
	barChartComFrom.setTotal("Total Rent=");
	barChartComFrom.setBarChartForms(barChartForms);
	exalToBarChart.barColumnChart(barChartComFrom,appPath);
	
}
public void expBarChartStu(HttpServletRequest request) throws IOException{
	  ServletContext context = request.getServletContext();
    String appPath = context.getRealPath("");
	List<BarChartForm> barChartForms=new ArrayList<>();
	List<Gread> greads=greadDao.getGreads();
	for(Gread gd:greads){
	List<Student> students=this.selectQuerryDao.getStudentByGread(gd);
	BarChartForm barChartForm=new BarChartForm();
	barChartForm.setName(gd.getGreadName());
	if(students==null){
		barChartForm.setValue(0);
	}else{
		barChartForm.setValue(students.size());
	}
	barChartForms.add(barChartForm);
	}
	BarChartComFrom barChartComFrom=new BarChartComFrom();
	barChartComFrom.setFileName("BarChartStudentListByGrade");
	barChartComFrom.setTitle("Student By Grade\nComparison of Student Grade in Student Data");
	barChartComFrom.setHorizontal("Grade Name");
	barChartComFrom.setVertical("Student Data");
	barChartComFrom.setTotal("Total Student=");
	barChartComFrom.setBarChartForms(barChartForms);
	exalToBarChart.barColumnChart(barChartComFrom,appPath);
}
public void expBarChartBySex(HttpServletRequest request) throws IOException{
	  ServletContext context = request.getServletContext();
  String appPath = context.getRealPath("");
 	List<BarChartForm> barChartForms=new ArrayList<>();
	List<String> sexs=new ArrayList<>();
	sexs.add("Male");
	sexs.add("Female");
	for(String sex:sexs){
	List<Student> students=this.selectQuerryDao.getRentStudentBySex(sex);
	BarChartForm barChartForm=new BarChartForm();
	barChartForm.setName(sex);
	if(students==null){
		barChartForm.setValue(0);
	}else{
		barChartForm.setValue(students.size());
	}
	barChartForms.add(barChartForm);
	}
	BarChartComFrom barChartComFrom=new BarChartComFrom();
	barChartComFrom.setFileName("BarChartRentListByGender");
	barChartComFrom.setTitle("Compare the Rent Data Of Male And Female");
	barChartComFrom.setHorizontal("Gender");
	barChartComFrom.setVertical("Rent Data");
	barChartComFrom.setTotal("Total Rent=");
	barChartComFrom.setBarChartForms(barChartForms);
	exalToBarChart.barColumnChart(barChartComFrom,appPath);
}
}
