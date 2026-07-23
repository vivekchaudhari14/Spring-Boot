package com.Employee_Managment.services;

import com.Employee_Managment.DTO.request.EmployeeRequest;
import com.Employee_Managment.DTO.response.EmployeeResponse;

public interface EmployeeService {
	
	EmployeeResponse createEmployee(EmployeeRequest request);
}
