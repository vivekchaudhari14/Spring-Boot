package com.librarymanagementsystem.practice.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarymanagementsystem.practice.entities.IssueBook;

@Repository

public interface IssueBookRepository extends JpaRepository<IssueBook, Long> {

    Optional<IssueBook> findByBookIdAndStatus(Long bookId, String status);

}