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
 * BookAuthor generated by hbm2java
 */
@Entity
@Table(name = "book_author", catalog = "mmhbusin_lmstu")
public class BookAuthor implements java.io.Serializable {

	private BookAuthorId id;
	private Author author;
	private Book book;

	public BookAuthor() {
	}

	public BookAuthor(BookAuthorId id, Author author, Book book) {
		this.id = id;
		this.author = author;
		this.book = book;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "bookId", column = @Column(name = "book_id", nullable = false)),
			@AttributeOverride(name = "authorId", column = @Column(name = "author_id", nullable = false)) })
	public BookAuthorId getId() {
		return this.id;
	}

	public void setId(BookAuthorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id", nullable = false, insertable = false, updatable = false)
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}