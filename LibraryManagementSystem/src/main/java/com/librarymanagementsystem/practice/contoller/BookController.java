package com.librarymanagementsystem.practice.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.librarymanagementsystem.practice.entities.Book;
import com.librarymanagementsystem.practice.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    
    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {

        Book savedBook = bookService.addBook(book);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        return ResponseEntity.ok(bookService.getAllBooks());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(book);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,
                                           @Valid @RequestBody Book book) {

        Book updatedBook = bookService.updateBook(id, book);

        if (updatedBook == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedBook);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {

        String message = bookService.deleteBook(id);

        if (message.equals("Book Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(message);
    }

}