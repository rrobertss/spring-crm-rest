/*
 *  Company: RS
 *  Project: spring-crm-rest
 *  Created: 25 sty 2022  20:59:19
 *  Author:  RS 		
 */
package pl.rsof.springdemo.rest;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <p></p><p>25 sty 2022</p>
 * @author RS
 *
 */
@ControllerAdvice
public class CustomerRestExceptionHandler {

	
	// exception handler for CustomerNotFoundException  
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse>handleException(CustomerNotFoundException nfe){
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(nfe.getMessage());
		error.setTimestamp(Instant.now().toEpochMilli());
//		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.NOT_FOUND);
		
	} 
	
	
	// exception handler to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse>handleException(Exception exc){
		CustomerErrorResponse error = new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(), 
				exc.getMessage(), 
				System.currentTimeMillis());
		
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
