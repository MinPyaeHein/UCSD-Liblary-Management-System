package com.coder.form;

import java.util.List;

import com.coder.model.AcademicYear;

public class AcademicYearRegisterForm {
private AcademicYearForm academicYearForm=null;
private List<AcademicYear> academicYears;
public AcademicYearForm getAcademicYearForm() {
	return academicYearForm;
}
public void setAcademicYearForm(AcademicYearForm academicYearForm) {
	this.academicYearForm = academicYearForm;
}
public List<AcademicYear> getAcademicYears() {
	return academicYears;
}
public void setAcademicYears(List<AcademicYear> academicYears) {
	this.academicYears = academicYears;
}
}
