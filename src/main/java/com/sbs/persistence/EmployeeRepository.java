package com.sbs.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	List<Employee> findByLastNameIgnoreCase(String lastname);

}
