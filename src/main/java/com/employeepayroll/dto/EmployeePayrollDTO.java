package com.employeepayroll.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import lombok.Data;


@Data
public class EmployeePayrollDTO {
	
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}+[a-zA-Z\\s]{2,}", message = "Employee Name Invalid (Starts with Capital Letter, Should Not Contain Numbers, Length more than 3)")
	private String name;
	
	@NotEmpty
	private String profileImage;
	
	@NotEmpty
	private String gender;
	
	private String notes;
	
//	@NotEmpty(message = "Address Cannot be Empty")
//	private String address;
	
//	@NotEmpty(message = "Email Cannot be empty")
//	@Email
//	private String email;
	
//	@NotNull(message = "Phone Number Cannot be Empty")
//	private long pno;
	
	@NotNull
	@Min(value = 200000, message = "Salary Should be more than 2 LPA")
	private double salary;
	
	@NotNull
	private List<String> department;
	
	@NotNull(message = "Date cannot be Empty")
	private String start;
	
}
