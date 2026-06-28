package com.springboot.api.book.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.api.book.dao.BookRepository;
import com.springboot.api.book.entities.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	// get All Student 
	
	public List<Book> getAllBook(){
		
		List<Book> book = (List<Book>) this.bookRepository.findAll();
		
		if(book.isEmpty()) {
			throw new RuntimeException("Book of Table is Empty");
		}
		
		return book;
	}

	public Book getBook(int bId) {

	    Optional<Book> book = bookRepository.findById(bId);

	    if (book.isPresent()) {
	        return book.get();
	    } else {
	        throw new RuntimeException("Id not found");
	    }
	}
	
	public Book addBook(Book book) {
		
		/*
		 * if (book.getTitle() == null || book.getTitle().isBlank()) { throw new
		 * RuntimeException("Title cannot be null"); } if (book.getAuthor() == null ||
		 * book.getAuthor().isBlank()) { throw new
		 * RuntimeException("Author cannot be null"); }
		 */
		
		Book b = this.bookRepository.save(book);
		return b;
	
	}

	public void deleteBook(int bId) {
		 if (!bookRepository.existsById(bId)) {
		        throw new RuntimeException("Book not found");
		    }

		    bookRepository.deleteById(bId);
	}

	public Book updateBook(Book book, int bookId) {

	    Optional<Book> existingBook = bookRepository.findById(bookId);

	    if (existingBook.isPresent()) {

	        Book b = existingBook.get();

	        b.setTitle(book.getTitle());
	        b.setAuthor(book.getAuthor());

	        return bookRepository.save(b);

	    } else {
	        throw new RuntimeException("Id Not found");
	    }
	}
}
