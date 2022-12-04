package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

	@Mock
	DepartmentRepository deptRepo;
	
	@InjectMocks
	DepartmentServiceImpl deptServ;
	
	List<Department> deptList;
	
	@BeforeEach
	public void setUp() {
		deptList = new LinkedList<>();
		
		deptList.add(new Department(109, "AABB"));
		deptList.add(new Department(199, "BBAA"));
		deptList.add(new Department(19, "CCBB"));
		deptList.add(new Department(999, "BBCC"));
		deptList.add(new Department(1090, "AABBCC"));

		Collections.sort(deptList, (o1, o2)-> o1.getDeptId()-o2.getDeptId());
	}
	
	@Test
	void testFindAllDepartment() {
	
		
		when(deptServ.findAllDepartment()).thenReturn(deptList);
		
		List<Department> deptsFound = deptServ.findAllDepartment();
		
		assertNotNull(deptsFound);
		assertEquals(deptList, deptsFound);
	}
	
	@Test
	void testSaveDepartment() {
		Department departmentToBeSaved = new Department(4455, "New Dept");		
		when(deptServ.saveDepartment(departmentToBeSaved)).thenReturn(departmentToBeSaved);
		Department savedDepartment = deptServ.saveDepartment(departmentToBeSaved);
		
		assertNotNull(savedDepartment);
		assertEquals(departmentToBeSaved, savedDepartment);
		assertEquals(departmentToBeSaved.getDeptId(), savedDepartment.getDeptId());
	}

	@Test
	void testFindADepartment() {
		Department deptToBeFound = new Department(109, "AABB");
		
//		deptServ.saveDepartment(deptToBeFound);
		when(deptServ.findADepartment(109)).thenReturn(deptToBeFound);

		
		Department deptFound = deptServ.findADepartment(deptToBeFound.getDeptId());

		System.out.println(deptFound);
//		assertEquals(deptToBeFound, deptFound);
	}
}
