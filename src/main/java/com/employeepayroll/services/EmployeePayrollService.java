package com.employeepayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.dto.ResponseDTO;
import com.employeepayroll.exception.PayrollException;
import com.employeepayroll.exception.PayrollException.exceptionType;
import com.employeepayroll.model.Employee;
import com.employeepayroll.repository.IEmployeePayrollRepository;

/**
 * Service Layer to make contact between DB and controller
 * Methods to implement API in the DB
 * @author Akash Saxena
 */
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	/**
	 * DB Repository object
	 */
	@Autowired
	private IEmployeePayrollRepository empRepo;
	
	/**
	 * Method to Implement API for printing all the employees from the DB
	 * @return Response DTO containing the list of all employees
	 */
	@Override
	public ResponseDTO getEmployees() {
		return new ResponseDTO("Here are all the employees in the Database", empRepo.findAll());
	}

	/**
	 * Method to add employees to the database
	 * @param Employee DTO
	 * @return Response DTO containing Employee Data added to the database
	 */
	@Override
	public ResponseDTO addEmployees(EmployeePayrollDTO employee) {
		Employee emp = new Employee(employee);
		return new ResponseDTO("Employee Added To Database Successfully", empRepo.save(emp));
	}

	/**
	 * Method to find an employee by the given id without any exception
	 * @deprecated Not Used now since the mapping to method with exception is implemented
	 * @param employee ID
	 * @return Employee Data via a Response DTO
	 */
	@Override
	public ResponseDTO findById(int id) {
		return new ResponseDTO("The Employee Details for the provided Id are", empRepo.findById(id).get());
	}

	/**
	 * Method to delete employee from database
	 * @param employee id
	 */
	@Override
	public void deleteEmployee(int id) {
		empRepo.deleteById(id);
	}

	/**
	 * Method to update employee data in database
	 * @param id and employee DTO
	 * @return updated employee data in response DTO 
	 */
	@Override
	public ResponseDTO updateName(int id, EmployeePayrollDTO emp) {
		return new ResponseDTO("Here are the Updated Details of the Employee", empRepo.save(new Employee(id, emp)));
	}

	/**
	 * Method to find an employee by the given id with exception
	 * @param employee ID
	 * @return Employee Data via a Response DTO
	 */
	@Override
	public ResponseDTO findEmployee(int id) {
		return new ResponseDTO("Employee By the Given ID is:", empRepo.findById(id).orElseThrow(()-> new PayrollException(exceptionType.EMPLOYEE_NOT_FOUND, "No Employee Found with such ID")));
	}

}
