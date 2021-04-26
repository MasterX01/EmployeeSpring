package com.employeepayroll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.employeepayroll.dto.EmployeePayrollDTO;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private String email;
	private long pno;
	private double salary;
	
	public Employee() {}
	
	public Employee(int id, EmployeePayrollDTO emp) {
		this.id = id;
		this.name = emp.getName();
		this.address = emp.getAddress();
		this.email = emp.getEmail();
		this.pno =	 emp.getPno();
		this.salary = emp.getSalary();

	}

	public Employee(EmployeePayrollDTO employee) {
		this.name = employee.getName();
		this.address = employee.getAddress();
		this.email = employee.getEmail();
		this.pno =	 employee.getPno();
		this.salary = employee.getSalary();
	}
	
	public int getId() { return id; }
	public String getName() { return name; }
	public String getAddress() { return address; }
	public String getEmail() { return email; }
	public long getPno() { return pno; }
	public double getSalary() { return salary; }
	
}
