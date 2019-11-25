package com.nare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nare.exception.EmployeeNotFoundException;
import com.nare.exception.ErrorHanlingClass;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<ErrorHanlingClass> handleCustomerNotFoundException() {
		ErrorHanlingClass e=new ErrorHanlingClass(400,"employye id  not found");
		return new ResponseEntity<ErrorHanlingClass>(e,HttpStatus.BAD_REQUEST);

	}

}
