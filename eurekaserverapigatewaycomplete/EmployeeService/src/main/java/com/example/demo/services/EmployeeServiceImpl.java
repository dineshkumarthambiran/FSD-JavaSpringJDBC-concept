package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo empRepo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee findAnEmployee(Integer eid) {
		// TODO Auto-generated method stub
		return empRepo.findById(eid).get();
	}

}
