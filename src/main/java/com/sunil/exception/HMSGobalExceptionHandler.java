package com.sunil.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class HMSGobalExceptionHandler {
	
	
	@ExceptionHandler(HMSExceptionHandler.class)
	public ResponseEntity<?> errorDto(HMSExceptionHandler ex,HttpServletRequest request){
		
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), 
				HttpStatus.NOT_FOUND.value(),  "NOT_FOUND", request.getRequestURI());
		
		 return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> beanValidation(MethodArgumentNotValidException ex, HttpServletRequest request)
	{
		//ex.getBindingResult().getFieldErrors().get(0);
		
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), 
				HttpStatus.NOT_FOUND.value(), ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage().toString() , 
				request.getRequestURI());
		
		return new ResponseEntity<> (errorResponse,HttpStatus.NOT_FOUND); 
	}

}
