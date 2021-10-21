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

import com.coder.exalForm.BarChartComFrom;
import com.coder.exalForm.BarChartForm;
import com.coder.form.BookGroupExalForm;
import com.coder.util.PrjSubFunction;
@Service
@Repository("exalToBarChart")
public class ExalToBarChart {

	public static void barColumnChart(BarChartComFrom barChartComFrom,String path) throws FileNotFoundException, IOException {
		
	       XSSFWorkbook wb=new XSSFWorkbook();
			String sheetName = barChartComFrom.getFileName();
			
			XSSFSheet sheet = wb.createSheet(sheetName);
            List<BarChartForm> barChartForms= barChartComFrom.getBarChartForms();
		
			Row row = sheet.createRow((short) 0);
		
			int total=0;
			Cell cell=null;
            for(int i=0;i<barChartForms.size();i++){
			 cell = row.createCell((short) i);
			 BarChartForm barChartForm=barChartForms.get(i);
			 cell.setCellValue(barChartForm.getName());
            }
            row = sheet.createRow((short) 1);
            for(int i=0;i<barChartForms.size();i++){
			cell = row.createCell((short) i);
			BarChartForm barChartForm=barChartForms.get(i);
			cell.setCellValue(barChartForm.getValue());
			total+=barChartForm.getValue();
            }

			
	       

			XSSFDrawing drawing = sheet.createDrawingPatriarch();
			XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 4, 7, 20);

			XSSFChart chart = drawing.createChart(anchor);
			chart.setTitleText(barChartComFrom.getTitle());
			chart.setTitleOverlay(false);

			XDDFChartLegend legend = chart.getOrAddLegend();
			legend.setPosition(LegendPosition.TOP_RIGHT);
			
			XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
            bottomAxis.setTitle(barChartComFrom.getHorizontal()+"\n"+barChartComFrom.getTotal()+total);
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            leftAxis.setTitle(barChartComFrom.getVertical());
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

			XDDFDataSource<String> countries = XDDFDataSourcesFactory.fromStringCellRange(sheet,
					new CellRangeAddress(0, 0, 0, barChartForms.size()-1));

			XDDFNumericalDataSource<Double> values = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
					new CellRangeAddress(1, 1, 0, barChartForms.size()-1));
			
			XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
            XDDFChartData.Series series1 = data.addSeries(countries, values);
            series1.setTitle("GroupName", null);
			data.setVaryColors(true);
			chart.plot(data);
			
           XDDFBarChartData bar = (XDDFBarChartData) data;
            bar.setBarDirection(BarDirection.BAR);
            bar.setBarDirection(BarDirection.COL);
           System.out.println("Arriving Exal Dowload");
            String filename = path+"\\META-INF\\"+barChartComFrom.getFileName()+".xlsx";
            //String filename = "D:\\dgl\\ExalToBarByOwner.xlsx";//"column-chart-top-seven-countries.xlsx";
			try (FileOutputStream fileOut = new FileOutputStream(filename)) {
				wb.write(fileOut);
				fileOut.flush();
				fileOut.close();
			}
			
		}
	}

