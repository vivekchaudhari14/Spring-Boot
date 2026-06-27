package com.springboot.api.book.services;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

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
		if(list.isEmpty()) {
			throw new RuntimeException("Book Not Found");
		}
		return list;
	}

	public Book getBook(int bId) {
		Book book = null;
		book = list.stream().filter(e->e.getId() == bId).findFirst().get();
		if(book == null) {
			throw new RuntimeException("Book Id Not found");
		}
		return book;
	}

	public Book addBook(Book book) {
		
		if (book.getTitle() == null || book.getTitle().isBlank()) {
	        throw new RuntimeException("Title cannot be null");
	    }
		if (book.getId()<=0) {
	        throw new RuntimeException("Id cannot be null");
	    }
		if (book.getAuthor() == null || book.getAuthor().isBlank()) {
	        throw new RuntimeException("Author cannot be null");
	    }
		
		list.add(book);
		return book;
	}

	public boolean deleteBook(int bId) {
		 return list.removeIf(book -> book.getId() == bId);
	}

	public boolean updateBook(Book book, int bookId) {
		 for (Book b : list) {
		        if (b.getId() == bookId) {
		            b.setTitle(book.getTitle());
		            b.setAuthor(book.getAuthor());
		            return true;
		        }
		    }

		    return false;
	}
}
