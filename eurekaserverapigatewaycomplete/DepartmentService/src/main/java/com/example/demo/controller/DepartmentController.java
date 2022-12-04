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

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService deptServ;
	
	@PostMapping("/department")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
		return new ResponseEntity<Department>(deptServ.saveDepartment(department), HttpStatus.CREATED);
	}
	
	@GetMapping("/department/{deptId}")
	public ResponseEntity<Department> findADepartment(@PathVariable Integer deptId) {
		return new ResponseEntity<Department>(deptServ.findADepartment(deptId), HttpStatus.OK);
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> findAllDepartments(){
		return new ResponseEntity<List<Department>>(deptServ.findAllDepartment(), HttpStatus.OK);
	}
}
