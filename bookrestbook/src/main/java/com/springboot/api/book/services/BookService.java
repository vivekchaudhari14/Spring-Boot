package com.springboot.api.book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.api.book.entities.Book;

@Component
public class BookService {
	private static List<Book> list = new ArrayList<>();
	
	static {
		
		list.add(new Book(1,"Java","abc"));
		list.add(new Book(2,"Python","def"));
		list.add(new Book(3,"Javascript","xyz"));
		list.add(new Book(4,"Golang","mno"));
		
	}
	
	// get All Student 
	
	public List<Book> getAllBook(){
		return list;
	}

	public Book getBook(int bId) {
		Book book = null;
		book = list.stream().filter(e->e.getId() == bId).findFirst().get();
		return book;
	}

	public Book addBook(Book book) {
		list.add(book);
		return book;
	}

	public void deleteBook(int bId) {
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId() == bId) {
				list.remove(i);
			}
		}
		
	}

	public Book updateBook(Book book, int bookId) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId() == bookId) {
				list.set(i, book);
				return book;
			}
			
		}
		return null;
	}
}
