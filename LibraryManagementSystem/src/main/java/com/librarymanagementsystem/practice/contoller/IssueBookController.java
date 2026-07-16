package com.librarymanagementsystem.practice.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.librarymanagementsystem.practice.services.IssueBookService;

@RestController
@RequestMapping("/issue")
public class IssueBookController {

    @Autowired
    private IssueBookService issueService;

    @PostMapping("/book/{bookId}/student/{studentId}")
    public String issueBook(@PathVariable Long bookId,
                            @PathVariable Long studentId) {

        return issueService.issueBook(bookId, studentId);
    }

    @PostMapping("/return/{bookId}")
    public String returnBook(@PathVariable Long bookId) {

        return issueService.returnBook(bookId);
    }
}