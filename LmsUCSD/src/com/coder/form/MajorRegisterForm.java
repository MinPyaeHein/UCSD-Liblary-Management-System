package com.coder.form;

import java.util.List;

import com.coder.model.Major;

public class MajorRegisterForm {
	private MajorForm majorForm=null;
	private List<Major> majors;
public MajorForm getMajorForm() {
		return majorForm;
	}
	public void setMajorForm(MajorForm majorForm) {
		this.majorForm = majorForm;
	}
	public List<Major> getMajors() {
		return majors;
	}
	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

}
