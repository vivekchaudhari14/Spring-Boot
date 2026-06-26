package com.springboot.api.book.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.api.book.entities.Book;
>>>>>>> 8e9ed04 (getAllBookHelper Working)
import com.springboot.api.book.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
<<<<<<< HEAD
	public String getAllBookHelper(){
		return "This is helper Method";
=======
	public List<Book> getAllBookHelper(){
		return this.bookService.getAllBook();
>>>>>>> 8e9ed04 (getAllBookHelper Working)
	}
}
