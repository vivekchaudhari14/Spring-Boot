package com.Employee_Managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee_Managment.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
