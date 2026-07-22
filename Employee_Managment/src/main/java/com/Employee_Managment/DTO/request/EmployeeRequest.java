package com.Employee_Managment.DTO.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.Employee_Managment.enump.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequest {
	
	@NotBlank(message = "First name is required")
	@Size(min = 3, max = 20, message = "First name must be between 3 and 20 characters")
	@Pattern(
	    regexp = "^[A-Za-z]+$",
	    message = "First name must contain only letters"
	)
	String firstName;
	
	
	@NotBlank(message = "Surname name is required")
	@Size(min = 3, max = 20, message = "Sur name must be between 3 and 20 characters")
	@Pattern(
	    regexp = "^[A-Za-z]+$",
	    message = "Sur name must contain only letters"
	)
	String surName;
	
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	 String email;
	
	
	@NotBlank(message = "Mobile number is required")
	@Pattern(
	    regexp = "^[6-9]\\d{9}$",
	    message = "Mobile number must contain exactly 10 digits and start with 6, 7, 8, or 9"
	)
	 String mobileNumber;
	
	
	@NotNull(message="Gender is Required")
	Gender gender;
	
	@NotNull(message = "Date of birth is required")
	@Past(message = "Date of birth must be in the past")
	@JsonFormat(pattern = "yyyy-MM-dd")
	 LocalDate dob;
	
	@NotNull(message = "Joining date is required")
	@PastOrPresent(message = "Joining date cannot be in the future")
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate joiningDate;
	
	@NotNull(message = "Salary is required")
	@PositiveOrZero(message = "Salary cannot be negative")
	 BigDecimal salary;
	
	@NotNull(message = "Department ID is required")
	@Positive(message = "Department ID must be greater than zero")
	 Long departmentId;
	
	@NotNull(message = "DesignationId Id is Required")
	@Positive(message = "Department Id must be Positive")
	Long designationId;
	
	@NotNull(message = "Status is Required")
	Boolean status;
	
}
