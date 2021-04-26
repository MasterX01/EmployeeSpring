package com.employeepayroll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.model.Employee;
import com.employeepayroll.repository.IEmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private IEmployeePayrollRepository empRepo;
	
	@Override
	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}

	public Employee addEmployees(EmployeePayrollDTO employee) {
		Employee emp = new Employee(employee);
		return empRepo.save(emp);
	}

	@Override
	public Employee findById(int id) {
		return empRepo.findById(id).get();
	}

	@Override
	public void deleteEmployee(int id) {
		empRepo.deleteById(id);;
	}

	@Override
	public Employee updateName(int id, EmployeePayrollDTO emp) {
		return empRepo.save(new Employee(id, emp));
	}

}
