package com.sbs.service;



import java.util.List;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.persistence.Employee;
import com.sbs.persistence.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public EmployeeResponse saveEmployee(Employee employee) {
		Employee savedEmployee = null;
		try{
			savedEmployee = employeeRepository.save(employee);
			LOGGER.info(String.format("Successfully created an employee with ID of '%s'", savedEmployee.getId()));
		}
		catch(Exception e){
			LOGGER.error(String.format("Error creating an employee : %s", e.getMessage()), e);
			throw new RuntimeException(String.format("Unable to create an employee."));
		}
		
		EmployeeResponse result = new  EmployeeResponse(savedEmployee, ResponseStatusType.OK, "");
		return result;
	}

	@Override
	public EmployeeResponse getEmployeeByID(String id) {
		Employee record = null;
		
		try{
			record = employeeRepository.findOne(id);
			if(record == null)
			{
				LOGGER.warn(String.format("No data found in employee table with ID '%s'", id));
				throw new RuntimeException(String.format("No data found in employee table with ID '%s'", id));
			}

			LOGGER.info(String.format("Successfully retrieved data for employee with ID '%s'", id));
		}
		catch(PersistenceException e){
			LOGGER.error(String.format("An error occurred while querying the employee data store with ID '%s': %s", id, e.getMessage()), e);
			throw new RuntimeException(String.format("Unable to query employee data store with the ID '%s'", id));
		}
		EmployeeResponse result = new  EmployeeResponse(record, ResponseStatusType.OK, "");
		return result;
	}

	@Override
	public EmployeeResponse getAllEmployees() {
		List<Employee> listEmps = null;
		try {
			listEmps = employeeRepository.findAll();
			LOGGER.info(String.format("Successfully retrieved all employees. Size: %d", listEmps.size()));
		}
		catch(PersistenceException e){
			LOGGER.error(String.format("An error occurred while querying for all employees: %s", e.getMessage()), e);
			throw new RuntimeException(String.format("Unable to query employee data store"));
		}
		EmployeeResponse result = new  EmployeeResponse(listEmps, ResponseStatusType.OK, "");
		return result;
	}

	@Override
	public EmployeeResponse updateEmployee(Employee employee) {
		Employee record = null;
		try{
			record = employeeRepository.findOne(employee.getId());
		}
		catch(Exception e){
			LOGGER.error(String.format("An error occurred while querying the employee data store with ID '%s': %s", employee.getId(), e.getMessage()), e);
			throw new RuntimeException(String.format("Unable to query employee data store with the ID '%s'", employee.getId()));
		}
		
		
		// employee does not exist
		if(record == null){
			LOGGER.error(String.format("Unable to find an employee in data store with ID '%s'.", employee.getId()));
			throw new RuntimeException(String.format("Unable to find an employee in data store with ID '%s'.", employee.getId()));
		}
		
		try{
			record = employeeRepository.save(employee);
			LOGGER.info(String.format("Successfully updated data for employee with ID '%s'", employee.getId()));
		}
		catch(Exception e){
			LOGGER.error(String.format("Error saving data for employee with ID '%s': %s", employee.getId(), e.getMessage()), e);
			throw new RuntimeException(String.format("Unable to save the data for the employee with the ID '%s'", employee.getId()));
		}
		
		EmployeeResponse result = new  EmployeeResponse(record, ResponseStatusType.OK, "");
		return result;
	}

	@Override
	public EmployeeResponse deleteEmployee(String id) {
		Employee record = null;
		
		try{
			record = employeeRepository.findOne(id);	
		}
		catch(PersistenceException e){
			LOGGER.error(String.format("An error occurred while querying the Employee data store with ID '%s': %s", id, e.getMessage()), e);
			throw new RuntimeException(String.format("Unable to query Employee data store with the ID '%s'", id));
		}

		try{
			employeeRepository.delete(record);
			LOGGER.info(String.format("Successfully removed Employee with ID '%s'", id));
		}
		catch(PersistenceException e){
			LOGGER.error(String.format("An error occurred while deleting the Employee with ID '%s': %s", id, e.getMessage()), e);
			throw new RuntimeException(String.format("Unable to delete Employee with the ID '%s'", id));
		}
		EmployeeResponse result = new  EmployeeResponse(null, ResponseStatusType.OK, "");
		return result;
	}

	@Override
	public EmployeeResponse getAllEmployeesByLastName(String lastname) {
		List<Employee> listEmps = null;
		try {
			listEmps = employeeRepository.findByLastNameIgnoreCase(lastname);
			LOGGER.info(String.format("Successfully retrieved all employees with lastName of: '%s'. Size: %d",
					lastname, listEmps.size()));
		}
		catch(PersistenceException e){
			LOGGER.error(String.format("An error occurred while querying for all employees with lastname '%s': %s",
					lastname, e.getMessage()), e);
			throw new RuntimeException(String.format("Unable to query employee data store"));
		}
		EmployeeResponse result = new  EmployeeResponse(listEmps, ResponseStatusType.OK, "");
		return result;
	}

}
