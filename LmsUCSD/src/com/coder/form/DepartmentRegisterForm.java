package com.coder.form;

import java.util.List;

import com.coder.model.Department;

public class DepartmentRegisterForm {
private DepartmentForm departmentForm;
private List<Department> departments;
public DepartmentForm getDepartmentForm() {
	return departmentForm;
}
public void setDepartmentForm(DepartmentForm departmentForm) {
	this.departmentForm = departmentForm;
}
public List<Department> getDepartments() {
	return departments;
}
public void setDepartments(List<Department> departments) {
	this.departments = departments;
}
}
