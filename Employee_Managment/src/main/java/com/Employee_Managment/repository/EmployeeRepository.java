package com.Employee_Managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Employee_Managment.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	boolean existsByEmail(String email);
	boolean existsByMobileNumber(String mobileNumber);
	
}
