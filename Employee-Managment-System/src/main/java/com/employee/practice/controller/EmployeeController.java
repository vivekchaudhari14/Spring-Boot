package com.employee.practice.controller;

import com.employee.practice.configuration.EmployeeConfig;


import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.practice.dto.EmployeeDTO;
import com.employee.practice.exception.ResourceNotFoundException;
import com.employee.practice.services.EmployeesService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
	
	private final EmployeeConfig employeeConfig;
	private final EmployeesService employeesService;
	
	public EmployeeController(EmployeesService employeesService, EmployeeConfig employeeConfig) {
		super();
		this.employeesService = employeesService;
		this.employeeConfig = employeeConfig;
	}

	@GetMapping("/secreatMsg")
	public String getMySecreatCode() {
		return "Secreat Code : gw!@#$%^&sjd1564";
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		return ResponseEntity.ok(employeesService.getAllEmployee());
	}
	
	@GetMapping(path = "/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeId") Long id){
		Optional<EmployeeDTO> employeeDto = employeesService.getEmployeeById(id);
		
		return employeeDto
				.map(emp -> ResponseEntity.ok(emp))
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found this id "+id));
		
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
		EmployeeDTO saveEmployee = employeesService.createNewEmployee(inputEmployee);
		return new ResponseEntity<>(saveEmployee,HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{employeeId}")
	public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable("employeeId") Long id) {
		return ResponseEntity.ok(employeesService.updateEmployeeById(employeeDTO,id));
	}
	
	@DeleteMapping(path = "/{employeeId}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable("employeeId") Long employeeId){
		boolean getDeleted = employeesService.deleteEmployeeById(employeeId);
		if (getDeleted) {
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(
	        @PathVariable Long id,
	        @RequestBody Map<String, Object> updates) {

	    EmployeeDTO employeeDTO = employeesService.updateEmployee(id, updates);

	    return ResponseEntity.ok(employeeDTO);
	}
}
