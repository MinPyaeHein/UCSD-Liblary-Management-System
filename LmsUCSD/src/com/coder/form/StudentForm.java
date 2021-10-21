package com.coder.form;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.coder.model.AcademicYear;
import com.coder.model.Gread;
import com.coder.model.Major;

public class StudentForm {
	private String studentId;
	private String yearId;
	private String greadId;
	private String majorId;
	private String password;
	private String rollNumber;
	private String memberId;
	private String studentName;
	private String gender;
	private String phone;
	private String createDate;
	private String email;
	private String address;
	private String address1;
	private MultipartFile[] imageFiles;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getGreadId() {
		return greadId;
	}
	public void setGreadId(String greadId) {
		this.greadId = greadId;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getYearId() {
		return yearId;
	}
	public MultipartFile[] getImageFiles() {
		return imageFiles;
	}
	public void setImageFiles(MultipartFile[] imageFiles) {
		this.imageFiles = imageFiles;
	}
	public void setYearId(String yearId) {
		this.yearId = yearId;
	}
}
