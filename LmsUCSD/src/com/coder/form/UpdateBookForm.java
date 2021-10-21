package com.coder.form;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.BookAuthor;
import com.coder.model.BookEdition;
import com.coder.model.BookGroup;
import com.coder.model.BookShell;
import com.coder.model.BookType;
public class UpdateBookForm {
private BookGroup bookGroup;
private String bookId=null;
private BookForm bookForm=null;
private BookEdition selectBookEdition;
ArrayList<BookAuthor> bookAuthors;
ArrayList<BookShell> bookShells;
ArrayList<BookType> bookTypes;
private Map<String,String> mapBookEditions=new HashedMap<String,String>();

public BookForm getBookForm() {
	return bookForm;
}
public void setBookForm(BookForm bookForm) {
	this.bookForm = bookForm;
}
public BookEdition getSelectBookEdition() {
	return selectBookEdition;
}
public void setSelectBookEdition(BookEdition selectBookEdition) {
	this.selectBookEdition = selectBookEdition;
}


public String getBookId() {
	return bookId;
}

public void setBookId(String bookId) {
	this.bookId = bookId;
}
public Map<String, String> getMapBookEditions() {
	return mapBookEditions;
}
public void setMapBookEditions(Map<String, String> mapBookEditions) {
	this.mapBookEditions = mapBookEditions;
}
public ArrayList<BookAuthor> getBookAuthors() {
	return bookAuthors;
}
public void setBookAuthors(ArrayList<BookAuthor> bookAuthors) {
	this.bookAuthors = bookAuthors;
}
public ArrayList<BookShell> getBookShells() {
	return bookShells;
}
public void setBookShells(ArrayList<BookShell> bookShells) {
	this.bookShells = bookShells;
}
public ArrayList<BookType> getBookTypes() {
	return bookTypes;
}
public void setBookTypes(ArrayList<BookType> bookTypes) {
	this.bookTypes = bookTypes;
}
public BookGroup getBookGroup() {
	return bookGroup;
}
public void setBookGroup(BookGroup bookGroup) {
	this.bookGroup = bookGroup;
}
}
