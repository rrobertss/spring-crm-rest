/*
 *  Company: RS
 *  Project: spring-crm-rest
 *  Created: 25 sty 2022  20:54:57
 *  Author:  RS 		
 */
package pl.rsof.springdemo.rest;

/**
 * <p>Error response</p><p>25 sty 2022</p>
 * @author RS
 *
 */
public class CustomerErrorResponse {

	private int status;
	private String message;
	private long timestamp;
	
	
	public CustomerErrorResponse() {}


	public CustomerErrorResponse(int status, String message, long timestamp) {
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
