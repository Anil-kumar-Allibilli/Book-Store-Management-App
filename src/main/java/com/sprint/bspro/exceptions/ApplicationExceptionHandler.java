package com.sprint.bspro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	/** Exception handling method for handling instances of InvalidUserNameException.
	 *  
	 * @param e The InvalidUserNameException that needs to be handled.
	 * @return A ResponseEntity containing an ExceptionResponse with details about the exception.
          The HTTP status is set to BAD_REQUEST (400).
	 */
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> exceptionHandle(InvalidUserNameException e) {
		ExceptionResponse response = new ExceptionResponse(e.getMessage(),e.getSrcName());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
}
