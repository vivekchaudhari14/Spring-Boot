package com.springboot.api.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@GetMapping("/books")
	public String getAllBookHelper(){
		return "This is helper Method";
	}
}
