package com.employeepayroll.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.employeepayroll.dto.EmployeePayrollDTO;

import lombok.Data;


/**
 * Employee model the variables will become columns in the DB tables
 * @author Aakash
 *
 */
@Entity
@Data
@Table(name = "employee_details")
public class Employee {
	
	/**
	 * Private key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String profileImage;
//	private String address;
//	private String email;
//	private long pno;
	private String gender;
	private double salary;
	private LocalDate start;
	private String notes;
	
	/**
	 * Department will become another table which will take employee id and department
	 * and put it in a table
	 */
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name="id"))
	@Column(name = "department")
	private List<String> department;
	
	public Employee() {}
	
	/**
	 * Constructor to update employee data
	 * @param id
	 * @param employee DTO
	 */
	public Employee(int id, EmployeePayrollDTO emp) {
		this.id = id;
		this.name = emp.getName();
//		this.address = emp.getAddress();
//		this.email = emp.getEmail();
//		this.pno =	 emp.getPno();
		this.notes = emp.getNotes();
		this.profileImage = emp.getProfileImage();
		this.gender = emp.getGender();
		this.salary = emp.getSalary();
		this.department = emp.getDepartment();
		this.start = LocalDate.parse(emp.getStart());

	}

	/**
	 * Constructor for adding new employee
	 * @param employee DTO
	 */
	public Employee(EmployeePayrollDTO employee) {
		this.name = employee.getName();
//		this.address = employee.getAddress();
//		this.email = employee.getEmail();
//		this.pno =	 employee.getPno();
		this.notes = employee.getNotes();
		this.profileImage = employee.getProfileImage();
		this.gender = employee.getGender();
		this.salary = employee.getSalary();
		this.department = employee.getDepartment();
		this.start = LocalDate.parse(employee.getStart());
	}
	
	
}
