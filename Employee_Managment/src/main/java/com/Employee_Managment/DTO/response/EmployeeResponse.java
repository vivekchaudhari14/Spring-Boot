package com.Employee_Managment.DTO.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import com.Employee_Managment.enump.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {
	
     Long id;
     String firstName;
     String surName;
     String email;
     String mobileNumber;
     Gender gender;
     LocalDate dob;
     LocalDate joiningDate;
     BigDecimal salary;
     Long departmentId;
     Long designationId;
     Boolean status;
     Instant createdAt;
     Instant updatedAt;
}
