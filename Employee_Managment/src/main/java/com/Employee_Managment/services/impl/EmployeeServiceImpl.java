package com.Employee_Managment.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Employee_Managment.DTO.request.EmployeeRequest;
import com.Employee_Managment.DTO.response.EmployeeResponse;
import com.Employee_Managment.entities.Employee;
import com.Employee_Managment.exception.DuplicateResourceException;
import com.Employee_Managment.repository.EmployeeRepository;
import com.Employee_Managment.services.EmployeeService;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRepository employeeRepository;
	ModelMapper modelMapper;

	@Override
	public EmployeeResponse createEmployee(EmployeeRequest request) {
		
		log.info("Creating Employee With Email : {}",request.getEmail());
		
		if(employeeRepository.existsByEmail(request.getEmail())) {
			throw new DuplicateResourceException("This Email"+ request.getEmail()+"Already Exists");
		}
		
		if(employeeRepository.existsByMobileNumber(request.getMobileNumber())) {
			throw new DuplicateResourceException("This Mobile Number"+request.getMobileNumber()+"Already Exist");
		}
		
		
		Employee employee = modelMapper.map(request, Employee.class);
		Employee savedEmployee = employeeRepository.save(employee);
		return modelMapper.map(savedEmployee, EmployeeResponse.class);
		
		
	}
	
	
}
