package com.coder.form;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.RentReturnTeacher;
import com.coder.model.Teacher;

public class TeacherRegisterForm {
	private List<Teacher> teachers;
	private String teacherId;
	private Teacher teacher;
	private TeacherForm teacherForm;
	private String message;
	private List<RentReturnTeacher> rentReturnTeachers;
	private Map<String,String> mapMembers=new HashedMap<String,String>();
	private Map<String,String> mapDepartments=new HashedMap<String,String>();
	private Map<String,String> mapPositions=new HashedMap<String,String>();
	private Map<String,String> mapAcademicYears=new HashedMap<String,String>();
	
	public TeacherForm getTeacherForm() {
		return teacherForm;
	}
	public void setTeacherForm(TeacherForm teacherForm) {
		this.teacherForm = teacherForm;
	}
	public Map<String, String> getMapDepartments() {
		return mapDepartments;
	}
	public void setMapDepartments(Map<String, String> mapDepartments) {
		this.mapDepartments = mapDepartments;
	}
	public Map<String, String> getMapPositions() {
		return mapPositions;
	}
	public void setMapPositions(Map<String, String> mapPositions) {
		this.mapPositions = mapPositions;
	}
	public Map<String, String> getMapAcademicYears() {
		return mapAcademicYears;
	}
	public Map<String, String> getMapMembers() {
		return mapMembers;
	}
	public void setMapMembers(Map<String, String> mapMembers) {
		this.mapMembers = mapMembers;
	}
	public void setMapAcademicYears(Map<String, String> mapAcademicYears) {
		this.mapAcademicYears = mapAcademicYears;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<RentReturnTeacher> getRentReturnTeachers() {
		return rentReturnTeachers;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setRentReturnTeachers(List<RentReturnTeacher> rentReturnTeachers) {
		this.rentReturnTeachers = rentReturnTeachers;
	}
}
