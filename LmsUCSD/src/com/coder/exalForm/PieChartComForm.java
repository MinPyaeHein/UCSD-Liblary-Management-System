package com.coder.exalForm;

import java.util.List;

public class PieChartComForm {
private List<PieChartForm> pieChartForms;
private String title;
private String fileName;
public List<PieChartForm> getPieChartForms() {
	return pieChartForms;
}
public void setPieChartForms(List<PieChartForm> pieChartForms) {
	this.pieChartForms = pieChartForms;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
}
