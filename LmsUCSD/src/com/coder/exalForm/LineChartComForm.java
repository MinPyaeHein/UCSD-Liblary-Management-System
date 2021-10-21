package com.coder.exalForm;

import java.util.List;

public class LineChartComForm {
private String barName;
private String lineName;
private String fileName;
private String title;
private List<LineChartForm> lineChartForms;
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public List<LineChartForm> getLineChartForms() {
	return lineChartForms;
}
public void setLineChartForms(List<LineChartForm> lineChartForms) {
	this.lineChartForms = lineChartForms;
}
public String getBarName() {
	return barName;
}
public void setBarName(String barName) {
	this.barName = barName;
}
public String getLineName() {
	return lineName;
}
public void setLineName(String lineName) {
	this.lineName = lineName;
}

}
