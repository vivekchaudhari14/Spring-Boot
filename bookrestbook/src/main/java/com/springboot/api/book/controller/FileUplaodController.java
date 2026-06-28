package com.springboot.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.api.book.helper.FileUploadHelper;

import jakarta.servlet.Servlet;

@RestController
public class FileUplaodController {
	
	@Autowired
	 private FileUploadHelper fileUploadHelper;
	
	@PostMapping(value = "/upload-file")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
		
		System.out.println(file.getSize());
		
		try {
				
				
				if(file.isEmpty()) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is empty");
		
				}
				
				if (file.getContentType() == null ||
					    !file.getContentType().startsWith("image/")) {
					    return ResponseEntity.badRequest().body("Only image files are allowed");
					}
				
				// file uplaod code
				boolean f = this.fileUploadHelper.uploadFile(file);
				if(f) {
					//return ResponseEntity.ok("File Uplaod Succesfully");
					return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("Images/").path(file.getOriginalFilename()).toUriString());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		                    .body("Upload failed: " + e.getMessage());
			}
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File Must be Jpeg or notEmpty , Try again !");
			
	}
}
