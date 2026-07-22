package com.Employee_Managment.services.impl;

import org.springframework.stereotype.Service;

import com.Employee_Managment.repository.EmployeeRepository;
import com.Employee_Managment.services.EmployeeService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRepository employeeRepository;
	
}
