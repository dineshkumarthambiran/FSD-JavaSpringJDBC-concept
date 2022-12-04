package com.example.demo.exception;

public class DepartmentNotFoundException extends Exception {
	private String message;

	public DepartmentNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "DepartmentNotFoundException [message=" + message + "]";
	}
}
