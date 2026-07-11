package com.employee.practice.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {
	
	private Long id;
	
	@NotBlank(message = "Name Of employee Should be not null")
	@Size(min = 3, max = 10, message = "Name Of employee Should be in This Range : [3,10]")
	private String name;
	
	@NotBlank(message = "Email of the employee cannot be blank")
	@Email(message = "Email should be a valid format")
	private String email;
	
	@NotNull(message ="Age of employee cannot be Null")
	@Size(min=18 , max = 80 , message = "Age of emplyee between : [18-80]")
	private Integer age;
	
	@PastOrPresent(message="Employee Joining must be past or present")
	private LocalDate dateOfJoining;
	
	@AssertTrue(message = "Employee Should be Active")
	@JsonProperty("isActice")
	private Boolean isActive;
	
	@NotBlank(message="Employee role can not be null")
	@Pattern(regexp = "^(ADMIN|USER)$",message = "Employee role can either USER Or ADMIN")
	private String role;
	
	@NotNull(message="Empoyee salary should not be null")
	@Digits(integer = 6,fraction = 3 , message = "Employee salary Should be In this Format XXXXXX.XXX")
	@DecimalMax(value = "100000.000")
	@DecimalMin(value = "100.500")
	private Double salary;
}
