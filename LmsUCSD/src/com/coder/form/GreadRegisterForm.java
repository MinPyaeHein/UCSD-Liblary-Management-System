package com.coder.form;

import java.util.List;

import com.coder.model.Gread;

public class GreadRegisterForm {
private GreadForm greadForm=null;
private List<Gread> greads;
public GreadForm getGreadForm() {
	return greadForm;
}
public void setGreadForm(GreadForm greadForm) {
	this.greadForm = greadForm;
}
public List<Gread> getGreads() {
	return greads;
}
public void setGreads(List<Gread> greads) {
	this.greads = greads;
}
}
