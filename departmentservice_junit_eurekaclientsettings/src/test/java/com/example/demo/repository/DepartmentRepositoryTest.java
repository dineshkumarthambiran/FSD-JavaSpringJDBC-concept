package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	DepartmentRepository deptRepo;
	
	List<Department> deptList = new LinkedList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		deptList.add(new Department(109, "AABB"));
		deptList.add(new Department(199, "BBAA"));
		deptList.add(new Department(19, "CCBB"));
		deptList.add(new Department(999, "BBCC"));
		deptList.add(new Department(1090, "AABBCC"));

		Collections.sort(deptList, (o1, o2)-> o1.getDeptId()-o2.getDeptId());
		
		deptRepo.saveAll(deptList);
	}

	@AfterEach
	void tearDown() throws Exception {
		deptRepo.deleteAll();
	}

	@Test
	void testFindAll() {
		List<Department> deptsFound = deptRepo.findAll();
		
		assertEquals(deptList.size(), deptsFound.size());
		assertEquals(deptList, deptsFound);
		assertEquals(deptList.get(deptList.size()-1), deptsFound.get(deptsFound.size()-1));
		assertEquals(deptList.get(0), deptsFound.get(0));
	}

	@Test
	void testSave() {
		Department department = new Department(2090, "GGHH");
		Department savedDepartment = deptRepo.save(department);
		
		assertNotNull(savedDepartment);
		assertEquals(department, savedDepartment);
		assertEquals(department.getDeptName(), savedDepartment.getDeptName());
	}

	@Test
	void testFindById() {
		Department department = new Department(109, "AABB");
		Department foundDepartment = deptRepo.findById(department.getDeptId()).get();
		assertNotNull(foundDepartment);
		assertEquals(department, foundDepartment);
		assertEquals(department.getDeptId(), foundDepartment.getDeptId());
		
	}
}
