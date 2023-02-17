package com.ty.springboot_project.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.net.HttpHeaders;
import com.ty.springboot_project.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<ResponseStructure<String>> IdNotFoundException(IdNotFoundException ex){
	ResponseStructure<String> responseStructure=new ResponseStructure<>();
	responseStructure.setMessage(ex.getMessage());
	responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
	responseStructure.setData("id not found exception");
	
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
}

@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
	List<ObjectError> errorList = ex.getAllErrors();
	Map<String, String> map = new LinkedHashMap<>();

	for (ObjectError err : errorList) {
		String feildName = ((FieldError) err).getField();
		String message = err.getDefaultMessage();

		map.put(feildName, message);
	}
	return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(ConstraintViolationException.class)
public ResponseEntity<Object> handleConstriantEntityViolationException(ConstraintViolationException constExcep) {

	Set<ConstraintViolation<?>> set = constExcep.getConstraintViolations();
	List<String> list = new ArrayList<>();
	for (ConstraintViolation<?> constViolation : set) {
		String name = constViolation.getMessage();
		list.add(name);
	}
	return new ResponseEntity<Object>(list, HttpStatus.BAD_REQUEST);
}
}
