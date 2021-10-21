package com.coder.form;

import java.util.Date;

import com.coder.model.Admin;
import com.coder.model.Book;
import com.coder.model.Student;

public class RentReturnForm {
	private String rentId;
	private String adminId;
	private String bookId;
	private String userId;
	private String rentDate;
	private String returnDate;
	private String dueDate;
	private String lateFeet;
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getLateFeet() {
		return lateFeet;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	public void setLateFeet(String lateFeet) {
		this.lateFeet = lateFeet;
	}
}
