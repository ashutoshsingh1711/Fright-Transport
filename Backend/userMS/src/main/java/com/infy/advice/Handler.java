package com.infy.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.infy.exception.UserNotFoundException;


@RestControllerAdvice
public class Handler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		Map<String, String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((er)->{
			String fieldname=((FieldError)er).getField();
			String message=er.getDefaultMessage();
			errors.put(fieldname, message);
		});
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleBusinessException(UserNotFoundException ex){
		Map<String, String> errors=new HashMap<>();
		errors.put("errorMessage", ex.getMessage());
		return errors;
	}
	
}
