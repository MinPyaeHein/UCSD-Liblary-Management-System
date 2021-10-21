package com.coder.form;

import java.util.List;

import com.coder.model.Book;
import com.coder.model.RentReturnStudent;
import com.coder.model.RentReturnTeacher;

public class RentReturnRegisterForm {
private RentReturnForm rentReturnForm=null;
private String message=null;
private String Id;
private String rentId=null;
private MessageForm messageForm;
private String title;
private List<RentReturnStudent> rentReturnStudents;
private List<RentReturnTeacher> rentReturnTeachers;


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



public MessageForm getMessageForm() {
	return messageForm;
}

public void setMessageForm(MessageForm messageForm) {
	this.messageForm = messageForm;
}

public RentReturnForm getRentReturnForm() {
	return rentReturnForm;
}

public void setRentReturnForm(RentReturnForm rentReturnForm) {
	this.rentReturnForm = rentReturnForm;
}


public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getRentId() {
	return rentId;
}

public void setRentId(String rentId) {
	this.rentId = rentId;
}

public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}

public List<RentReturnTeacher> getRentReturnTeachers() {
	return rentReturnTeachers;
}

public void setRentReturnTeachers(List<RentReturnTeacher> rentReturnTeachers) {
	this.rentReturnTeachers = rentReturnTeachers;
}

}
