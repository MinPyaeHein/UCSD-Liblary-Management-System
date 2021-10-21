package com.coder.model;
// Generated May 28, 2020 10:14:49 PM by Hibernate Tools 5.0.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BookGroup generated by hbm2java
 */
@Entity
@Table(name = "book_group", catalog = "mmhbusin_lmstu")
public class BookGroup implements java.io.Serializable {

	private Integer bookGroupId;
	private String groupName;
	private String groupCode;
	private Set<Type> types = new HashSet<Type>(0);
	private Set<Book> books = new HashSet<Book>(0);

	public BookGroup() {
	}

	public BookGroup(String groupName, String groupCode) {
		this.groupName = groupName;
		this.groupCode = groupCode;
	}

	public BookGroup(String groupName, String groupCode, Set<Type> types, Set<Book> books) {
		this.groupName = groupName;
		this.groupCode = groupCode;
		this.types = types;
		this.books = books;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "book_group_id", unique = true, nullable = false)
	public Integer getBookGroupId() {
		return this.bookGroupId;
	}

	public void setBookGroupId(Integer bookGroupId) {
		this.bookGroupId = bookGroupId;
	}

	@Column(name = "group_name", nullable = false, length = 200)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "group_code", nullable = false, length = 100)
	public String getGroupCode() {
		return this.groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookGroup")
	public Set<Type> getTypes() {
		return this.types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookGroup")
	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
