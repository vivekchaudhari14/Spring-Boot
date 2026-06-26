package com.springboot.api.book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.api.book.entities.Book;

@Component
public class BookService {
	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(1,"java","james gosling"));
		list.add(new Book(1,"java","james gosling"));
		list.add(new Book(1,"java","james gosling"));
		list.add(new Book(1,"java","james gosling"));
		
	}
	
	// get All Student 
	
	public List<Book> getAllBook(){
		return list;
	}
}
