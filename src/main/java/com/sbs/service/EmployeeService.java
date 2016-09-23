package com.sbs.service;


import com.sbs.persistence.Employee;


public interface EmployeeService {
	
	/**
	 * This method saves Employee entity to the database and returns the saved Employee entity.
	 * @param employee
	 * @return the Employee
	 */
	public EmployeeResponse saveEmployee(Employee employee);
	
	/**
	 * This method retrieves the employee entity from the database given refID.
	 * @param refID
	 * @return the Employee
	 */
	public EmployeeResponse getEmployeeByID(String id);
	
	/**
	 * This method retrieves the all employees.
	 * @param 
	 * @return the Employees list
	 */
	public EmployeeResponse getAllEmployees();
	
	/**
	 * This method updates Employee entity to the database and returns the updated Employee entity.
	 * @param employee
	 * @return the Employee
	 */
	public EmployeeResponse updateEmployee(Employee employee);
	
	/**
	 * This method deletes the employee entity from the database given id.
	 * @param refID
	 * @return the status
	 */
	public EmployeeResponse deleteEmployee(String id);
	
	/**
	 * This method retrieves the all employees for the given lastname.
	 * @param 
	 * @return the Employees list
	 */
	public EmployeeResponse getAllEmployeesByLastName(String lastname);

	
}
