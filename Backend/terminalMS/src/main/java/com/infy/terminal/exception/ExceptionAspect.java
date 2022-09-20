package com.infy.terminal.exception;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAspect {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorMessage> notFoundException(NotFoundException e)
	{
		ErrorMessage error = new ErrorMessage(null);
		
		ResponseEntity<ErrorMessage> entity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> ExceptionHandling(Exception e)
	{
		ResponseEntity<String> entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		return entity;
	}

}
