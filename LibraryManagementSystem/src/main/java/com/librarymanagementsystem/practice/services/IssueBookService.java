package com.librarymanagementsystem.practice.services;
import com.librarymanagementsystem.practice.entities.Student;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagementsystem.practice.entities.IssueBook;
import com.librarymanagementsystem.practice.repository.BookRepository;
import com.librarymanagementsystem.practice.repository.IssueBookRepository;
import com.librarymanagementsystem.practice.repository.StudentRepository;
import com.librarymanagementsystem.practice.entities.Book;


@Service
public class IssueBookService {

    @Autowired
    private IssueBookRepository issueRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    
    public String issueBook(Long bookId, Long studentId) {

        Book book = bookRepository.findById(bookId).orElse(null);

        Student student = studentRepository.findById(studentId).orElse(null);

        if (book == null) {
            return "Book Not Found";
        }

        if (student == null) {
            return "Student Not Found";
        }

        if (!book.getAvailable()) {
            return "Book Already Issued";
        }

        IssueBook issueBook = new IssueBook();

        issueBook.setBook(book);
        issueBook.setStudent(student);
        issueBook.setIssueDate(LocalDate.now());
        issueBook.setStatus("ISSUED");

        issueRepository.save(issueBook);

        book.setAvailable(false);
        bookRepository.save(book);

        return "Book Issued Successfully";
    }
    
    
    public String returnBook(Long bookId) {

        IssueBook issueBook = issueRepository
                .findByBookIdAndStatus(bookId, "ISSUED")
                .orElse(null);

        if (issueBook == null) {
            return "No Issued Book Found";
        }

        Book book = issueBook.getBook();

        issueBook.setReturnDate(LocalDate.now());
        issueBook.setStatus("RETURNED");

        issueRepository.save(issueBook);

        book.setAvailable(true);
        bookRepository.save(book);

        return "Book Returned Successfully";
    }

}