package com.librarymanagementsystem.practice.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.librarymanagementsystem.practice.entities.Book;
import com.librarymanagementsystem.practice.repository.BookRepository;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    

    
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    
    public Book updateBook(Long id, Book newBook) {

        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {
            book.setTitle(newBook.getTitle());
            book.setAuthor(newBook.getAuthor());
            book.setCategory(newBook.getCategory());
            book.setIsbn(newBook.getIsbn());
            book.setAvailable(newBook.getAvailable());

            return bookRepository.save(book);
        }

        return null;
    }

    
    public String deleteBook(Long id) {

        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {
            bookRepository.delete(book);
            return "Book Deleted Successfully";
        }

        return "Book Not Found";
    }

}
