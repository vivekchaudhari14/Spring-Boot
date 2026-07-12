package com.employee.practice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.employee.practice.Repositorys.EmployeeRepository;
import com.employee.practice.dto.EmployeeDTO;
import com.employee.practice.entities.EmployeeEntity;
import com.employee.practice.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
public class EmployeesService {
	
	
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;
	
	public EmployeesService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
		super();
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
	}

	public List<EmployeeDTO> getAllEmployee() {

	    List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

	    return employeeEntities
	            .stream()
	            .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
	            .collect(Collectors.toList());
	}

	public Optional<EmployeeDTO> getEmployeeById(Long id) {
		
		return employeeRepository.findById(id).map(EmployeeEntity -> modelMapper.map(EmployeeEntity, EmployeeDTO.class));
	}

	public EmployeeDTO createNewEmployee(@Valid EmployeeDTO inputEmployee) {
		EmployeeEntity newEmployeeEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
		EmployeeEntity savedEmployeeEntity = employeeRepository.save(newEmployeeEntity);
		
		return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
	}
	
	public EmployeeDTO updateEmployeeById(@Valid EmployeeDTO employeeDTO,Long id) {
		isExistByEmployeeById(id);
		EmployeeEntity currentEmployee = modelMapper.map(employeeDTO, EmployeeEntity.class);
		currentEmployee.setId(id);
		EmployeeEntity updateEmployee = employeeRepository.save(currentEmployee);
		return modelMapper.map(updateEmployee, EmployeeDTO.class);
		
	}
	
	public void isExistByEmployeeById(Long employeeId) {
		Optional<EmployeeEntity> exist = employeeRepository.findById(employeeId);
		if (!exist.isPresent()) {
			throw new ResourceNotFoundException("Employee Id Not found "+employeeId);
		}
		
	}

	public boolean deleteEmployeeById(Long employeeId) {
		isExistByEmployeeById(employeeId);
		employeeRepository.deleteById(employeeId);
		return true;
	}

	public EmployeeDTO updateEmployee(Long id, Map<String, Object> updates) {
		
		isExistByEmployeeById(id);
		
	    EmployeeEntity employee = employeeRepository.findById(id).orElse(null);

	    if (employee == null) {
	        return null;
	    }

	    if (updates.containsKey("name")) {
	        employee.setName((String) updates.get("name"));
	    }

	    if (updates.containsKey("email")) {
	        employee.setEmail((String) updates.get("email"));
	    }

	    if (updates.containsKey("age")) {
	        employee.setAge((Integer) updates.get("age"));
	    }

	    if (updates.containsKey("salary")) {
	        employee.setSalary(Double.valueOf(updates.get("salary").toString()));
	    }

	    if (updates.containsKey("role")) {
	        employee.setRole((String) updates.get("role"));
	    }

	    if (updates.containsKey("isActive")) {
	        employee.setIsActive((Boolean) updates.get("isActive"));
	    }

	    if (updates.containsKey("dateOfJoining")) {
	        employee.setDateOfJoining(LocalDate.parse(updates.get("dateOfJoining").toString()));
	    }

	    EmployeeEntity saved = employeeRepository.save(employee);

	    return modelMapper.map(saved, EmployeeDTO.class);
	}
	
	
}
