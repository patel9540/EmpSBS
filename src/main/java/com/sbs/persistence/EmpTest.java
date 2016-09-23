package com.sbs.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class EmpTest {

	public static void main(String[] args) throws Exception {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("D:\\jpatel\\employeesbs\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
		
		EmployeeRepository empRepo = ctx.getBean(EmployeeRepository.class);
		
		Employee employee = new Employee();
		Date date = new Date();

		employee.setFirstName("John");
		employee.setLastName("Smith");
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
		empRepo.save(employee);

		System.out.println("Done Inserting data in Employee table.");

		// Print all records
		System.out.println("Print Employee Records in database.");
		List<Employee> empData = (List<Employee>) empRepo.findByLastNameIgnoreCase("Smith");
		for (Employee empRec : empData) {
			System.out.println(empRec);
		}
		
		System.out.println("Done with testing of Employee.");

		//ctx.close();

	}
}
