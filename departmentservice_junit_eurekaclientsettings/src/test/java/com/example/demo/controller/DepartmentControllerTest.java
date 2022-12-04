package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@WebMvcTest
class DepartmentControllerTest {
//	To create a fake DepartmentService instance using mockito
	@MockBean
	DepartmentService deptServ;

	@Autowired
	MockMvc mockMvc;
	
	ObjectMapper mapper = new ObjectMapper();
	ObjectWriter writer  = mapper.writer();
	
	@Test
	void testFindAllDepartments() throws Exception {
		
//		Arrange, Act and Assert
//		Trying to simulate that the method findAllDepartments() returns a fake list of data after being called
		List<Department> deptList = new LinkedList<Department>();
		
		deptList.add(new Department(12345, "HR"));
		deptList.add(null);
		deptList.add(new Department(1245, "Admin"));
		deptList.add(new Department(145, "Finance"));
		deptList.add(new Department(1235, "QA"));
		deptList.add(new Department(345, "CG"));

//		deptServ.findAllDepartment();
		when(deptServ.findAllDepartment()).thenReturn(deptList);
		
		mockMvc.perform(get("/department")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$", Matchers.hasSize(6)))
		.andExpect(jsonPath("$[1]", Matchers.nullValue()))
		.andExpect(jsonPath("$[2].deptName", Matchers.is("Admin")));
		;
		
	}
	
	@Test
	void testFindADepartment() throws Exception {
		Department deptToFind = new Department(1000, "XYZ");
		
		when(deptServ.findADepartment(deptToFind.getDeptId())).thenReturn(deptToFind);
		
		mockMvc.perform(get("/department/1000").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.deptName", Matchers.is("XYZ")))
		.andExpect(jsonPath("$.deptId", Matchers.is(deptToFind.getDeptId())))
		;
	}
	
	@Test
	void testSaveDepartment() throws Exception {
		Department deptToSave = new Department(114477, "ABC");
		String content = writer.writeValueAsString(deptToSave);
		
		when(deptServ.saveDepartment(deptToSave)).thenReturn(deptToSave);
		
		mockMvc.perform(post("/department")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isCreated())
//			.andExpect(jsonPath("$", Matchers.notNullValue()))
		;
	}


}
