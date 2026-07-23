package com.Employee_Managment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee_Managment.DTO.request.EmployeeRequest;
import com.Employee_Managment.DTO.response.EmployeeResponse;
import com.Employee_Managment.services.EmployeeService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal=true)
public class EmployeeController {
	
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest request){
		EmployeeResponse response = employeeService.createEmployee(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
}
