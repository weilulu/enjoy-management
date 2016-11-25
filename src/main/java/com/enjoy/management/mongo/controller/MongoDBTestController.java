package com.enjoy.management.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.management.mongo.entity.Employee;
import com.enjoy.management.mongo.entity.EmployeeRepository;

@RestController
@RequestMapping(value="/mongo")
public class MongoDBTestController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value="test",method = RequestMethod.GET)
	public void test(){
		Employee ram = new Employee(1,"Ram",20);
		Employee shyam = new Employee(2,"Shyam",20);
		employeeRepository.deleteAll();
		employeeRepository.save(ram);
		employeeRepository.save(shyam);
		
		Employee emp = employeeRepository.getEmployeeByName("Ram");
		System.out.println(emp.getName());
	
	}
}
