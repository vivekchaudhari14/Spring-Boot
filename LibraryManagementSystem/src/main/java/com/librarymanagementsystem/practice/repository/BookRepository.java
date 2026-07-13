package com.librarymanagementsystem.practice.repository;

import java.util.Optional;

import com.librarymanagementsystem.practice.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByTitle(String title);

}