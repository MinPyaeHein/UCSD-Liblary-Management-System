package com.coder.form;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.coder.model.Shell;

public class BookForm {
    private String bookId;
	private String bookName;
	private String editionId;
	private String editionName;
	private String createDate;
	private String bookGroupId;
	private String qty;
	private String isbn;
	private String publisherDate;
	private MultipartFile[] imageFiles;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEditionId() {
		return editionId;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public void setEditionId(String editionId) {
		this.editionId = editionId;
	}
	public String getPublisherDate() {
		return publisherDate;
	}
	public void setPublisherDate(String publisherDate) {
		this.publisherDate = publisherDate;
	}
	public String getBookGroupId() {
		return bookGroupId;
	}
	public void setBookGroupId(String bookGroupId) {
		this.bookGroupId = bookGroupId;
	}
	public String getEditionName() {
		return editionName;
	}
	public void setEditionName(String editionName) {
		this.editionName = editionName;
	}
	public MultipartFile[] getImageFiles() {
		return imageFiles;
	}
	public void setImageFiles(MultipartFile[] imageFiles) {
		this.imageFiles = imageFiles;
	}
	

}
