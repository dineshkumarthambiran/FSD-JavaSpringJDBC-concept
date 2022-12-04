package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
}

//findAll 		---> Will give all the records from the table in the form a list
//save 	  		---> Will save a record into the table
//findById		---> Will fetch a record in the table
//existsById	---> Will return true if the record is available otherwise false