package com.Employee_Managment.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.Employee_Managment.enump.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="employee")
public class Employee {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;


	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "surname", nullable = false)
	    private String surName;

	    @Column(name = "email", unique = true, nullable = false)
	    private String email;

	    @Column(name = "mobile_number", unique = true, nullable = false)
	    private String mobileNumber;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private Gender gender;

	    private LocalDate dob;

	    private LocalDate joiningDate;

	    private BigDecimal salary;

	    private Long departmentId;

	    private Long designationId;

	    private Boolean status;

	    @CreationTimestamp
	    private Instant createdAt;

	    @UpdateTimestamp
	    private Instant updatedAt;
	
}
