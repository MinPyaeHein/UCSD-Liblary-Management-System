package com.coder.model;
// Generated May 28, 2020 10:14:49 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BookShell generated by hbm2java
 */
@Entity
@Table(name = "book_shell", catalog = "mmhbusin_lmstu")
public class BookShell implements java.io.Serializable {

	private BookShellId id;
	private Book book;
	private Shell shell;

	public BookShell() {
	}

	public BookShell(BookShellId id, Book book, Shell shell) {
		this.id = id;
		this.book = book;
		this.shell = shell;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "bookId", column = @Column(name = "book_id", nullable = false)),
			@AttributeOverride(name = "shellId", column = @Column(name = "shell_id", nullable = false)) })
	public BookShellId getId() {
		return this.id;
	}

	public void setId(BookShellId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shell_id", nullable = false, insertable = false, updatable = false)
	public Shell getShell() {
		return this.shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

}
