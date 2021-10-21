package com.coder.form;

import java.util.List;

import com.coder.model.Author;

public class AuthorRegisterForm {
	private AuthorForm authorForm=null;
	private List<AuthorForm> authorForms;
	private List<Author> authors;

	public List<AuthorForm> getAuthorForms() {
		return authorForms;
	}

	public void setAuthorForms(List<AuthorForm> authorForms) {
		this.authorForms = authorForms;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public AuthorForm getAuthorForm() {
		return authorForm;
	}

	public void setAuthorForm(AuthorForm authorForm) {
		this.authorForm = authorForm;
	}

}
