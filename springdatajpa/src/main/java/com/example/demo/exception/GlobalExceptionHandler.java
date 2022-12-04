package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private String deptExists = "Department already exists...";
	private String deptNotFound = "Department Not Found...";

	
	@ExceptionHandler(value = DepartmentAlreadyExistsException.class)
	public ResponseEntity<String> departmentAlreadyExistsException() {
		return new ResponseEntity<String>(deptExists, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = DepartmentNotFoundException.class)
	public ResponseEntity<String> departmentNotFoundException(){
		return new ResponseEntity<String>(deptNotFound, HttpStatus.NOT_FOUND);
	}
}
