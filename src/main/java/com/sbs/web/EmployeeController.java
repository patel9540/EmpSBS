package com.sbs.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbs.persistence.Employee;
import com.sbs.service.EmployeeResponse;
import com.sbs.service.EmployeeService;
import com.sbs.service.ResponseStatusType;


@RestController
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * REST end point that retrieves the Employee entity from the database given refID.
	 * @param refID
	 * @return the Employee
	 * 
	 */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployeeByID(@PathVariable("id") String id) {
		LOGGER.info(String.format("Retrieving Employee with ID '%s'", id));
		return employeeService.getEmployeeByID(id);
	}
	
	
	/*
	 * Rest end point that creates Employee entity to the database and returns the saved Employee entity.
	 * @param Employee
	 * @return the Employee
	 * 
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse saveEmployee(@RequestBody Employee employee){
		LOGGER.info(String.format("Trying to save the Employee with FirstName:'%s', LastName:'%s'", employee.getFirstName(), employee.getLastName()));
		return employeeService.saveEmployee(employee);
	}
		
	/*
	 * Rest end point that updates Employee entity to the database and returns the updated Employee entity.
	 * @param Employee
	 * @return the Employee
	 * 
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse updateEmployee(@RequestBody Employee employee){
		LOGGER.info(String.format("Trying to update the Employee with ID '%s'", employee.getId()));
		return employeeService.updateEmployee(employee);
	}
	
	/*
	 * Rest end point that deletes the Employee entity from the database given refID, and returns the deleted Employee entity.
	 * @param Employee
	 * @return the Employee
	 * 
	 */
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmployee(@PathVariable("id") String id){
		LOGGER.info(String.format("Deleting Employee with ID '%s'", id));
		return employeeService.deleteEmployee(id);
	}

	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public EmployeeResponse exceptionHandler(Exception e){
		LOGGER.info(String.format("Handling exception: %s", e.getMessage()), e);
		EmployeeResponse result = new EmployeeResponse(null, ResponseStatusType.ERROR, e.getMessage());
		return result;
	}
	
	/*
	 * Rest end point that gets all the employees.
	 * @param 
	 * @return the List<Employee>
	 * 
	 */
	@RequestMapping(value = "/employee/all", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getAllEmployees(){
		LOGGER.info(String.format("Retrieving all employees .."));
		return employeeService.getAllEmployees();
	}
		
	/*
	 * Rest end point that gets all the employees that matches lastname (input parameter).
	 * @param 
	 * @return the List<Employee>
	 * 
	 */
	@RequestMapping(value = "/employee/lastname/{lastname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getAllEmployeesByLastName(@PathVariable("lastname") String lastname) {
		LOGGER.info(String.format("Retrieving Employees with lastname of '%s'", lastname));
		return employeeService.getAllEmployeesByLastName(lastname);
	}


}
