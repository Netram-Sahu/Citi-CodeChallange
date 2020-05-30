package com.citi.netram.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * GlobalExceptionHandler is used to handle global exception
 * @ControllerAdvice annotation allows to handle global exceptions
 * @ExceptionHandler is an annotation used to handle the specific exceptions and sending the custom responses to the client
 * */

@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * This method is used to handle customer id not found exception
	 * */
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(" Some error at server" +errorDetails, HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is used to handle customer id not found exception
	 * */
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(AccountNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(" Some error at server" +errorDetails, HttpStatus.NOT_FOUND);
	}
	/**
	 * This method is used to handle internal server exception
	 * */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(" Some error at server" +errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}