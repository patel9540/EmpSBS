package com.sbs.service;


import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sbs.persistence.EmpPosCatType;
import com.sbs.persistence.Employee;
import com.sbs.persistence.EmployeeRepository;
import com.sbs.service.ResponseStatusType;


/**
 * EmployeeServiceImplTest - unit tests for Employee Services
 * 
 *
 */


@RunWith(EasyMockRunner.class)
public class EmployeeServiceImplTest {
	
	@TestSubject
	private EmployeeServiceImpl testService = new EmployeeServiceImpl();
	
	@Mock(fieldName="employeeRepository", name="mockemployeeRepository", type=MockType.STRICT)
	private EmployeeRepository mockemployeeRepository;
	
	
	private Employee employee;
	private String employeeId = "ffe41b057d52d0731bf2f05c";
	private String lastName = "Smith";
	
	@Before
	public void setUp() {
		employee = new Employee();
		Date date = new Date();
		employee.setId(employeeId);
		employee.setFirstName("John");
		employee.setLastName(lastName);
		employee.setMiddleName("Bob");
		employee.setEmailAddress("jacksmith@abcd.com");
		employee.setPhoneNumber("202-555-5555");
		employee.setPositionCategory(EmpPosCatType.DIRECTOR);
		employee.setDateHired(date);
		employee.setAddress1("123 Any Street");
		employee.setAddress2("Apt. 1A");
		employee.setCity("MyTown");
		employee.setState("MD");
		employee.setZipCode("20850");
		employee.setActive(true);

	}
	
	@Test
	public void testSaveEmployee()
	{
		expect(mockemployeeRepository.save(employee)).andReturn(employee);
		replay(mockemployeeRepository);
		
		EmployeeResponse emp = testService.saveEmployee(employee);
    	assertNotNull("Expected non-null Employee return value but received null", emp.getData().getData());
    	// add code to check various attributes of employee
	}
	
	@Test
	public void testUpdateEmployee()
	{
		expect(mockemployeeRepository.findOne(employeeId)).andReturn(employee);
		expect(mockemployeeRepository.save(employee)).andReturn(employee);
		replay(mockemployeeRepository);
		
		EmployeeResponse emp = testService.updateEmployee(employee);
    	assertNotNull("Expected non-null Employee return value but received null", emp.getData().getData());
    	// add code to check various attributes of employee
	}

	@Test
	public void testGetEmployeeByID()
	{
		expect(mockemployeeRepository.findOne(employeeId)).andReturn(employee);
		replay(mockemployeeRepository);
		
		EmployeeResponse emp = testService.getEmployeeByID(employeeId);
    	assertNotNull("Expected non-null Employee return value but received null", emp.getData().getData());
    	// add code to check various attributes of employee 
	}
	

	@Test
	public void testGetAllEmployees()
	{
		List<Employee> list = new ArrayList<Employee>();
		list.add(employee);
		expect(mockemployeeRepository.findAll()).andReturn(list);
		replay(mockemployeeRepository);
		
		EmployeeResponse emp = testService.getAllEmployees();
		@SuppressWarnings("unchecked")
		List<Employee> empList = (List<Employee>) emp.getData().getData();
    	assertNotNull("Expected non-null Employee return value but received null", emp.getData().getData());
    	assertEquals(1, empList.size());
	}
	
	@Test
	public void testDeleteEmployee()
	{
		expect(mockemployeeRepository.findOne(employeeId)).andReturn(employee);
		mockemployeeRepository.delete(employee);
		EasyMock.expectLastCall().once();
		replay(mockemployeeRepository);
		
		EmployeeResponse result = testService.deleteEmployee(employeeId);
		assertEquals(ResponseStatusType.OK, result.getData().getStatus());
	}
	
	@Test
	public void testGetAllEmployeesByLastName()
	{
		List<Employee> list = new ArrayList<Employee>();
		list.add(employee);
		expect(mockemployeeRepository.findByLastNameIgnoreCase(lastName)).andReturn(list);
		replay(mockemployeeRepository);
		
		EmployeeResponse emp = testService.getAllEmployeesByLastName(lastName);
		@SuppressWarnings("unchecked")
		List<Employee> empList = (List<Employee>) emp.getData().getData();
    	assertNotNull("Expected non-null Employee return value but received null", emp.getData().getData());
    	assertEquals(1, empList.size());
	}
	
}

