package com.librarymanagementsystem.practice.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "issue_books")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class IssueBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate issueDate;

    private LocalDate returnDate;

    private String status;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
    
}