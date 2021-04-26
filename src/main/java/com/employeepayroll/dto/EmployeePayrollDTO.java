package com.employeepayroll.dto;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
	private String name;
	private String address;
	private String email;
	private long pno;
	private double salary;
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public long getPno() {
		return pno;
	}
	public double getSalary() {
		return salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPno(long pno) {
		this.pno = pno;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
