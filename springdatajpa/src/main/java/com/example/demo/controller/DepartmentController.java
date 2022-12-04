package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.DepartmentAlreadyExistsException;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentRepository deptRepo;
	
//	@Autowired
//	public DepartmentController(DepartmentRepository deptRepo) {
//		super();
//		this.deptRepo = deptRepo;
//	}

	@PostMapping("/dept")
	public ResponseEntity<Department> insertARecord(@RequestBody Department department) throws DepartmentAlreadyExistsException {
		
		if(deptRepo.existsById(department.getDeptId())) {
			throw new DepartmentAlreadyExistsException("Department already available...");
		}
		Department savedDepartment = deptRepo.save(department);
		return new ResponseEntity<Department>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("/depts")
	public ResponseEntity<List<Department>> findAllDepartments(){
		List<Department> departments = deptRepo.findAll();
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
	}
	
	@GetMapping("/dept/{deptId}")
	public ResponseEntity<Department> findingADepartment(@PathVariable Integer deptId) throws DepartmentNotFoundException{
		if(!deptRepo.existsById(deptId)) {
			throw new DepartmentNotFoundException("Department not found");
		}
		Department department = deptRepo.findById(deptId).get();
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}
	
	@DeleteMapping("/dept/{deptId}")
	public void deleteARecord(@PathVariable Integer deptId) {
		deptRepo.deleteById(deptId);
	}
}

















