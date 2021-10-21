package com.coder.exal;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.BarDirection;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.XDDFBarChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFPieChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.exalForm.PieChartComForm;
import com.coder.exalForm.PieChartForm;
import com.coder.form.BookGroupExalForm;
import com.coder.util.PrjSubFunction;

@Repository("exalToPieChart")
public class ExalToPieChart {
	
	public static void pieChart(PieChartComForm pieChartComForm,String path) throws FileNotFoundException, IOException {
	
	     try (XSSFWorkbook wb = new XSSFWorkbook()) {

	            XSSFSheet sheet = wb.createSheet(pieChartComForm.getFileName()+"");

	            // Create row and put some cells in it. Rows and cells are 0 based.
	            Row row = sheet.createRow((short) 0);

	           List<PieChartForm> pieChartForms= pieChartComForm.getPieChartForms();
	         
	           Cell cell=null;
	           
	            for(int i=0;i<pieChartForms.size();i++){
	            cell = row.createCell((short)i );
	            PieChartForm pieChartForm=pieChartForms.get(i);
	            System.out.println(pieChartForm.getName()+":"+pieChartForm.getValue());
	            cell.setCellValue(pieChartForm.getName()+"("+pieChartForm.getValue()+")");
	           
	           }
	           
	
	            row = sheet.createRow((short) 1);
               
                for(int i=0;i<pieChartForms.size();i++){
	            cell = row.createCell((short)i);
	            PieChartForm pieChartForm=pieChartForms.get(i);
	            cell.setCellValue(pieChartForm.getValue());
	          
                }
	            

	            XSSFDrawing drawing = sheet.createDrawingPatriarch();
	            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 4, 7, 20);

	            XSSFChart chart = drawing.createChart(anchor);
	            chart.setTitleText(pieChartComForm.getTitle()+"");
	            chart.setTitleOverlay(false);

	            XDDFChartLegend legend = chart.getOrAddLegend();
	            legend.setPosition(LegendPosition.TOP_RIGHT);

	            XDDFDataSource<String> countries = XDDFDataSourcesFactory.fromStringCellRange(sheet,
	                    new CellRangeAddress(0, 0, 0, (pieChartForms.size()-1)));

	            XDDFNumericalDataSource<Double> values = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
	                    new CellRangeAddress(1, 1, 0, (pieChartForms.size()-1)));

//	          XDDFChartData data = chart.createData(ChartTypes.PIE, null, null);
	            XDDFChartData data = new XDDFPieChartData( chart.getCTChart().getPlotArea().addNewPieChart());
	            data.setVaryColors(true);

	            
	            data.addSeries(countries, values);
	            chart.plot(data);

	            // Write output to an excel file
	            try (FileOutputStream fileOut = new FileOutputStream(path+"\\META-INF\\"+pieChartComForm.getFileName()+".xlsx")) {
	                wb.write(fileOut);
	            }
	        }

	    }
	}