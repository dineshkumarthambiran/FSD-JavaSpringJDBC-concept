package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;

public interface DepartmentService {
	public Department saveDepartment(Department department);
	public List<Department> findAllDepartment();
	public Department findADepartment(Integer deptId);
}
