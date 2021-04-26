package com.employeepayroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.model.Employee;
import com.employeepayroll.services.IEmployeePayrollService;

@RestController
@RequestMapping({"/employeepayroll", ""})
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService empPayrollService;
	
	/**
	 * API to add new employee to DB
	 * @param employee
	 * @return Employee Data
	 */
	@PostMapping("/addemployee")
	public ResponseEntity<Employee> addEmployees(@RequestBody EmployeePayrollDTO employee) {
		Employee emp =  empPayrollService.addEmployees(employee);
		return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}
	
	/**
	 * API to list all the employees in DB
	 * @return List of employee in Response Entity
	 */
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> emp =  empPayrollService.getEmployees();
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	/**
	 * API to find employee by ID
	 * @param id
	 * @return Employee Data 
	 */
	@GetMapping("findemployee/{id}")
	public Employee findByEmplyee(@PathVariable int id) {
		return empPayrollService.findById(id);
	}
	
	 /**
	  * API to delete employee data from sql
	  * @param id
	  */
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable int id) {
		empPayrollService.deleteEmployee(id);
	}
	
	/**
	 * API for updation of different fields
	 * @param id
	 * @return Employee Data with updated fields
	 */
	@PutMapping("/update/{id}")
	public Employee updateName(@PathVariable int id, @RequestBody EmployeePayrollDTO emp) {
		return empPayrollService.updateName(id, emp);
	}
	
}
