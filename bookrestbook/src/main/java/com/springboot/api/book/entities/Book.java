package com.springboot.api.book.entities;

import org.hibernate.annotations.OnDelete;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_id")
	private int id;
	@Column(name = "book_title")
	private String title;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	
//	public Book() {
//		super();
//	}
//
//	public Book(int id, String title, String author) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.author = author;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public Author setAuthor(Author author) {
		return this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
}
