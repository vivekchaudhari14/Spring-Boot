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
}
