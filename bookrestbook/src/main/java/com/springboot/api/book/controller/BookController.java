package com.springboot.api.book.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.api.book.entities.Book;
import com.springboot.api.book.services.BookService;


@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<?> getAllBookHelper(){
		
		try {
			List<Book> book = this.bookService.getAllBook();
			return ResponseEntity.ok(book);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<?> getBookHelper(@PathVariable("bookId") int bId) {
		try {
			Book book = this.bookService.getBook(bId);
			return ResponseEntity.ok(book);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/books")
	public ResponseEntity<?> addBookHelper(@RequestBody Book book) {
		try {
			return ResponseEntity.ok(bookService.addBook(book));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity deleteBookHelper(@PathVariable("bookId") int bId) {
		if(this.bookService.deleteBook(bId)) {
			return ResponseEntity.ok("Book Deleted");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id Not found");
	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity bookUpdateHelper(@RequestBody Book book,@PathVariable("bookId") int bookid) {
		boolean updated = bookService.updateBook(book, bookid);
		if(updated) {
			return ResponseEntity.ok("Book Updated");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id Not Match");
	}
}
