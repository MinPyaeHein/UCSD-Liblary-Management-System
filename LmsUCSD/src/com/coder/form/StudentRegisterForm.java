package com.coder.form;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.RentReturnStudent;
import com.coder.model.Student;

public class StudentRegisterForm {
private StudentForm studentForm=null;
private Student student;
private String studentId;
private List<Student> students;
private String message;
private List<RentReturnStudent> rentReturnStudents;
private Map<String,String> mapMembers=new HashedMap<String,String>();
private Map<String,String> mapMajors=new HashedMap<String,String>();
private Map<String,String> mapAcademicYears=new HashedMap<String,String>();
private Map<String,String> mapGreads=new HashedMap<String,String>();

public StudentForm getStudentForm() {
	return studentForm;
}

public void setStudentForm(StudentForm studentForm) {
	this.studentForm = studentForm;
}

public Map<String, String> getMapMajors() {
	return mapMajors;
}

public void setMapMajors(Map<String, String> mapMajors) {
	this.mapMajors = mapMajors;
}

public Map<String, String> getMapAcademicYears() {
	return mapAcademicYears;
}

public void setMapAcademicYears(Map<String, String> mapAcademicYears) {
	this.mapAcademicYears = mapAcademicYears;
}

public Map<String, String> getMapGreads() {
	return mapGreads;
}

public void setMapGreads(Map<String, String> mapGreads) {
	this.mapGreads = mapGreads;
}

public List<Student> getStudents() {
	return students;
}

public void setStudents(List<Student> students) {
	this.students = students;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

public String getStudentId() {
	return studentId;
}

public void setStudentId(String studentId) {
	this.studentId = studentId;
}

public Map<String, String> getMapMembers() {
	return mapMembers;
}

public void setMapMembers(Map<String, String> mapMembers) {
	this.mapMembers = mapMembers;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public List<RentReturnStudent> getRentReturnStudents() {
	return rentReturnStudents;
}

public void setRentReturnStudents(List<RentReturnStudent> rentReturnStudents) {
	this.rentReturnStudents = rentReturnStudents;
}



}
