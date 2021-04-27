package com.employeepayroll.services;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.dto.ResponseDTO;

public interface IEmployeePayrollService {
	
	ResponseDTO getEmployees();

	ResponseDTO addEmployees(EmployeePayrollDTO employee);

	ResponseDTO findById(int id);

	void deleteEmployee(int id);

	ResponseDTO updateName(int id, EmployeePayrollDTO emp);

	ResponseDTO findEmployee(int id);
}
