package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public Employee findAnEmployee(int eid) {
		return empRepo.findById(eid).get();
	}

}
