package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empServ;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(empServ.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/{eid}")
	public ResponseEntity<Employee> findAnEmployee(@PathVariable Integer eid){
		return new ResponseEntity<Employee>(empServ.findAnEmployee(eid), HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> findAllEmployee(){
		return new ResponseEntity<List<Employee>>(empServ.findAllEmployee(), HttpStatus.OK);
	}
}
