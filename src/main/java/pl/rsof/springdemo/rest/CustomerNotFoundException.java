/*
 *  Company: RS
 *  Project: spring-crm-rest
 *  Created: 25 sty 2022  20:57:02
 *  Author:  RS 		
 */
package pl.rsof.springdemo.rest;

/**
 * <p></p><p>25 sty 2022</p>
 * @author RS
 *
 */
public class CustomerNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
