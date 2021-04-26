package com.employeepayroll.services;

import java.util.List;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.model.Employee;

public interface IEmployeePayrollService {
	
	List<Employee> getEmployees();

	Employee addEmployees(EmployeePayrollDTO employee);

	Employee findById(int id);

	void deleteEmployee(int id);

	Employee updateName(int id, EmployeePayrollDTO emp);
}
