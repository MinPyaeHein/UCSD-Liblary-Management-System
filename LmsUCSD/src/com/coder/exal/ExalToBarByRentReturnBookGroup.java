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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.form.BookGroupExalForm;
import com.coder.util.PrjSubFunction;
@Service
@Repository("exalToBarByRentReturnBookGroup")
public class ExalToBarByRentReturnBookGroup {

	public static void barColumnChart(List<BookGroupExalForm> bookGroupExalForms,XSSFWorkbook wb,
		String path) throws FileNotFoundException, IOException {
		
            
		String sheetName = "ShowRentBookByGroup";
			
			XSSFSheet sheet = wb.createSheet(sheetName);

		
			Row row = sheet.createRow((short) 0);
		
			int total=0;
			Cell cell=null;
            for(int i=0;i<bookGroupExalForms.size();i++){
			 cell = row.createCell((short) i);
			 BookGroupExalForm bookGroupExalForm=bookGroupExalForms.get(i);
			cell.setCellValue(bookGroupExalForm.getBookGroupName());
            }
            row = sheet.createRow((short) 1);
            for(int i=0;i<bookGroupExalForms.size();i++){
			cell = row.createCell((short) i);
			BookGroupExalForm bookGroupExalForm=bookGroupExalForms.get(i);
			cell.setCellValue(bookGroupExalForm.getRentCount());
			total+=bookGroupExalForm.getRentCount();
            }

			
	       

			XSSFDrawing drawing = sheet.createDrawingPatriarch();
			XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 4, 7, 20);

			XSSFChart chart = drawing.createChart(anchor);
			chart.setTitleText("Show Rent Return Book History By Book Group");
			chart.setTitleOverlay(false);

			XDDFChartLegend legend = chart.getOrAddLegend();
			legend.setPosition(LegendPosition.TOP_RIGHT);
			
			XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
            bottomAxis.setTitle(" Book Group Name "+"Rent List Total="+total);
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            leftAxis.setTitle("Rent List");
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

			XDDFDataSource<String> countries = XDDFDataSourcesFactory.fromStringCellRange(sheet,
					new CellRangeAddress(0, 0, 0, bookGroupExalForms.size()-1));

			XDDFNumericalDataSource<Double> values = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
					new CellRangeAddress(1, 1, 0, bookGroupExalForms.size()-1));
			
			XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
            XDDFChartData.Series series1 = data.addSeries(countries, values);
            series1.setTitle("GroupName", null);
			data.setVaryColors(true);
			chart.plot(data);
			
           XDDFBarChartData bar = (XDDFBarChartData) data;
            bar.setBarDirection(BarDirection.BAR);
            bar.setBarDirection(BarDirection.COL);
           System.out.println("Arriving Exal Dowload");
            String filename = path+"\\META-INF\\ExalToBarBookGroupByRent.xlsx";
            
			try (FileOutputStream fileOut = new FileOutputStream(filename)) {
				wb.write(fileOut);
				fileOut.flush();
				fileOut.close();
			}
			
		}
	}

