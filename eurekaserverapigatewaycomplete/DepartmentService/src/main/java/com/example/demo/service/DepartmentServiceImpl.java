package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public Department saveDepartment(Department department) {
		return deptRepo.save(department);
	}

	@Override
	public List<Department> findAllDepartment() {
		return deptRepo.findAll();
	}

	@Override
	public Department findADepartment(Integer eid) {
		return deptRepo.findById(eid).get();
	}

}
