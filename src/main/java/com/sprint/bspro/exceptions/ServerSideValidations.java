package com.sprint.bspro.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ServerSideValidations extends ResponseEntityExceptionHandler {

	/** Handle method arguments that fail validation by providing a custom error response.
	 * 
	 * @param exp The MethodArgumentNotValidException representing the validation failure.
	 * @param headers The HttpHeaders to be included in the response.
	 * @param status The HttpStatus to be included in the response.
	 * @param request The WebRequest providing information about the request.
	 * @return A ResponseEntity Object containing a map of property names and error messages as the response body,
         with HttpStatus set to BAD_REQUEST (400).
	 */
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exp,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		
	
		System.out.println("Inside ValidationExceptions");
		Map<String, String> errorMap = new HashMap<>();
		
		
		List<ObjectError> errorList = exp.getBindingResult().getAllErrors();

		errorList.stream().forEach((e)->{
			String propertyName = ((FieldError)e).getField();
			String errorMsg = e.getDefaultMessage();
			
			errorMap.put(propertyName, errorMsg);
		});
		
		
		return new ResponseEntity<Object>(errorMap,HttpStatus.BAD_REQUEST);
		
	}
}
