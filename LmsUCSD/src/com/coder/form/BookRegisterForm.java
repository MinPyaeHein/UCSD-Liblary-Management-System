package com.coder.form;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class BookRegisterForm {
	private BookForm bookForm=null;
	private Map<String,String> mapBookEditions=new HashedMap<String,String>();

	public BookForm getBookForm() {
		return bookForm;
	}

	public void setBookForm(BookForm bookForm) {
		this.bookForm = bookForm;
	}

	public Map<String, String> getMapBookEditions() {
		return mapBookEditions;
	}

	public void setMapBookEditions(Map<String, String> mapBookEditions) {
		this.mapBookEditions = mapBookEditions;
	}
	
	

}
