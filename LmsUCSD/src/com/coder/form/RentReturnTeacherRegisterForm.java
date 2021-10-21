package com.coder.form;

import java.util.List;

import com.coder.model.Book;
import com.coder.model.RentReturnStudent;
import com.coder.model.RentReturnTeacher;

public class RentReturnTeacherRegisterForm {
private RentReturnTeacherForm rentReturnTeacherForm=null;
private String message=null;
private String teacherId;
private String teaRentId=null;
private MessageForm messageForm;
private List<RentReturnTeacher> rentReturnTeachers;


public MessageForm getMessageForm() {
	return messageForm;
}

public void setMessageForm(MessageForm messageForm) {
	this.messageForm = messageForm;
}

public RentReturnTeacherForm getRentReturnTeacherForm() {
	return rentReturnTeacherForm;
}

public void setRentReturnTeacherForm(RentReturnTeacherForm rentReturnTeacherForm) {
	this.rentReturnTeacherForm = rentReturnTeacherForm;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getTeacherId() {
	return teacherId;
}

public void setTeacherId(String teacherId) {
	this.teacherId = teacherId;
}

public String getTeaRentId() {
	return teaRentId;
}

public void setTeaRentId(String teaRentId) {
	this.teaRentId = teaRentId;
}

public List<RentReturnTeacher> getRentReturnTeachers() {
	return rentReturnTeachers;
}

public void setRentReturnTeachers(List<RentReturnTeacher> rentReturnTeachers) {
	this.rentReturnTeachers = rentReturnTeachers;
}



}
