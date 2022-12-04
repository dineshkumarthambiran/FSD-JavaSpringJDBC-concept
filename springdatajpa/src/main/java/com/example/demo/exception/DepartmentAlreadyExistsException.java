package com.example.demo.exception;

public class DepartmentAlreadyExistsException extends Exception {
	private String message;

	public DepartmentAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "DepartmentAlreadyExistsException [message=" + message + "]";
	}
}
