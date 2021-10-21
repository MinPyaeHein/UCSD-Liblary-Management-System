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

import com.coder.dao.BookGroupDao;
import com.coder.dao.GreadDao;
import com.coder.dao.SelectQuerryDao;
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
import com.coder.model.Book;
import com.coder.model.BookGroup;
import com.coder.model.Gread;
import com.coder.model.Student;

@Service
@Repository("expRentByGroupServic")
public class ExpRentByGroupServic {
@Autowired
private BookGroupDao bookGroupDao;
@Autowired
private SelectQuerryDao selectQuerryDao;
@Autowired
private ExalToBarChart exalToBarChart;
@Autowired
private ExalToPieChart exalToPieChart;
@Autowired
private ExalToBarAndLineChart exalToBarAndLineChart;
public void prepaerRentByGroup(ExpExalViewForm expExalViewForm){
	expExalViewForm.setTitle("Export Excel Rent List By Group");
	expExalViewForm.setPath("expRentByGroupSubmitPath");
	expExalViewForm.getMapExalTypes().put("1","Pie Chart Rent List By Group");
	expExalViewForm.getMapExalTypes().put("2","Bar and Line Chart Rent List By Group ");
	expExalViewForm.getMapExalTypes().put("3","Bar Chart Books By Group");
	expExalViewForm.getMapExalTypes().put("4","Export Excel");
	
}
public void expRentByGroup(ExpExalViewForm expExalViewForm) throws FileNotFoundException, IOException{

	if(expExalViewForm.getExalTypeId()!=null){
	int id=Integer.parseInt(expExalViewForm.getExalTypeId().trim());
	if(id==1){
		expPieChart(expExalViewForm.getRequest());
	}else if(id==2){
		expBarAndLineChart(expExalViewForm.getResponse(),expExalViewForm.getRequest());
	}else if(id==3){
		expBarChart(expExalViewForm.getRequest());
	}
}}
public void expPieChart(HttpServletRequest requ) throws IOException{
	ServletContext context = requ.getServletContext();
    String appPath = context.getRealPath("");
 
	List<PieChartForm> piChartForms=new ArrayList<>();
	List<BookGroup> bookGroups=bookGroupDao.getBookGroups();
	for(BookGroup bg:bookGroups){
	
	List<Student> students=this.selectQuerryDao.getRentBookByGroupId(bg);
	
	PieChartForm piChartForm=new PieChartForm();
	piChartForm.setName(bg.getGroupName());
	if(students==null){
		piChartForm.setValue(0);
	}else{
		piChartForm.setValue(students.size());
	}
	piChartForms.add(piChartForm);
	}
	
	System.out.println();
	PieChartComForm pieChartComForm=new PieChartComForm();
	pieChartComForm.setFileName("pieChartBookListByGroup");
	pieChartComForm.setTitle("Rent Data By Group\nComparison of Book Group in Rent Data");
	pieChartComForm.setPieChartForms(piChartForms);
	exalToPieChart.pieChart(pieChartComForm,appPath);
}
public void expBarAndLineChart(HttpServletResponse resp,HttpServletRequest req) throws IOException{
	List<LineChartForm> lineChartForms=new ArrayList<>();
	List<BookGroup> bookGroups=bookGroupDao.getBookGroups();
	for(BookGroup bg:bookGroups){
		
	List<Book> books=this.selectQuerryDao.getBooksByGroup(bg);
	List<Student> students=this.selectQuerryDao.getRentBookByGroupId(bg);
	
	LineChartForm lineChartForm=new LineChartForm();
	if(books==null){
		lineChartForm.setBarValue(0);
	}else{
		lineChartForm.setBarValue(books.size());
	}
	if(students==null){
		lineChartForm.setLineValue(0);	
	}else{
		lineChartForm.setLineValue(students.size());
	}
	lineChartForm.setName(bg.getGroupName());
    lineChartForms.add(lineChartForm);
	}
	LineChartComForm lineChartComForm=new LineChartComForm();
	lineChartComForm.setLineChartForms(lineChartForms);
	lineChartComForm.setBarName("Book");
	lineChartComForm.setLineName("RentList");
	lineChartComForm.setFileName("LineAndBarChartRentByGroup");
	lineChartComForm.setTitle("Analysis of the relation between Library Book Groups and Rent Data ");
	try{
	exalToBarAndLineChart.barAndLineChart(lineChartComForm,resp,req);
	}catch (Exception e) {
	}
	
}
public void expBarChart(HttpServletRequest requ) throws IOException{
	 ServletContext context = requ.getServletContext();
     String appPath = context.getRealPath("");
     System.out.println("appPath = " + appPath);
	List<BarChartForm> barChartForms=new ArrayList<>();
	List<BookGroup> bookGroups=bookGroupDao.getBookGroups();
	for(BookGroup bg:bookGroups){
	
	List<Book> books=this.selectQuerryDao.getBooksByGroup(bg);
	
	BarChartForm barChartForm=new BarChartForm();
	barChartForm.setName(bg.getGroupName());

	if(books==null){
		barChartForm.setValue(0);
	}else{
		barChartForm.setValue(books.size());
	}
	barChartForms.add(barChartForm);
	}
	
	
	BarChartComFrom barChartComFrom=new BarChartComFrom();
	barChartComFrom.setFileName("BarChartBookListByGroup");
	barChartComFrom.setTitle("Books List By Group\nComparison of Book Groups In Book Data");
	barChartComFrom.setHorizontal("Group Name");
	barChartComFrom.setVertical("Book Data");
	barChartComFrom.setTotal("Total Book=");
	barChartComFrom.setBarChartForms(barChartForms);
	
	//exalToPieChart2.pieChart(pieChartComForm);
	exalToBarChart.barColumnChart(barChartComFrom,appPath);
	//exalDowloadServic.doDownload(req, resp, "/META-INF/pieChartRentListByGrade.xlsx");
	
}
}
