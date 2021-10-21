package com.coder.form;

import java.util.ArrayList;
import java.util.List;

import com.coder.model.Book;

public class SaveBookConfrimForm {
private String bookId=null;
private List<Book> books;
private  ArrayList<AuthorForm> authorForms;
private  ArrayList<ShellForm> shellForms;
private ArrayList<TypeForm> typeForms;
private Book book;
public String getBookId() {
	return bookId;
}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public ArrayList<AuthorForm> getAuthorForms() {
	return authorForms;
}
public void setAuthorForms(ArrayList<AuthorForm> authorForms) {
	this.authorForms = authorForms;
}
public ArrayList<ShellForm> getShellForms() {
	return shellForms;
}
public List<Book> getBooks() {
	return books;
}
public void setBooks(List<Book> books) {
	this.books = books;
}
public void setShellForms(ArrayList<ShellForm> shellForms) {
	this.shellForms = shellForms;
}

public ArrayList<TypeForm> getTypeForms() {
	return typeForms;
}
public void setTypeForms(ArrayList<TypeForm> typeForms) {
	this.typeForms = typeForms;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}


}
