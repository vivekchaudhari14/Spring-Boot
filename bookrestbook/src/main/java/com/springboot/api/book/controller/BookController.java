package com.springboot.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.springboot.api.book.entities.Book;
import com.springboot.api.book.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBookHelper(){
		return this.bookService.getAllBook();
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBookHelper(@PathVariable("bookId") int bId) {
		return this.bookService.getBook(bId);
	}
	
	@PostMapping("/books")
	public Book addBookHelper(@RequestBody Book book) {
		return this.bookService.addBook(book);
	}
}
