package com.coder.form;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.BookGroup;

public class BookGroupRegisterForm {
private List<BookGroup> bookGroups;
private BookGroupForm bookGroupForm=null;

private Map<String,String> mapBookGroups=new HashedMap<String,String>();

public BookGroupForm getBookGroupForm() {
	return bookGroupForm;
}
public void setBookGroupForm(BookGroupForm bookGroupForm) {
	this.bookGroupForm = bookGroupForm;
}
public Map<String, String> getMapBookGroups() {
	return mapBookGroups;
}
public void setMapBookGroups(Map<String, String> mapBookGroups) {
	this.mapBookGroups = mapBookGroups;
}
public List<BookGroup> getBookGroups() {
	return bookGroups;
}
public void setBookGroups(List<BookGroup> bookGroups) {
	this.bookGroups = bookGroups;
}

}
