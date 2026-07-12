package com.employee.practice.configuration;



import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
	
	@Bean
	public ModelMapper getRowMapper() {
		return new ModelMapper();
	}
}
