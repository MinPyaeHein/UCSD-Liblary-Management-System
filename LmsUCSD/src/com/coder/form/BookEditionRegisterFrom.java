package com.coder.form;

import java.util.List;

import com.coder.model.BookEdition;

public class BookEditionRegisterFrom {
private BookEditionForm bookEditionForm;
private List<BookEdition> bookEditions;

public List<BookEdition> getBookEditions() {
	return bookEditions;
}
public void setBookEditions(List<BookEdition> bookEditions) {
	this.bookEditions = bookEditions;
}
public BookEditionForm getBookEditionForm() {
	return bookEditionForm;
}
public void setBookEditionForm(BookEditionForm bookEditionForm) {
	this.bookEditionForm = bookEditionForm;
} 
}
