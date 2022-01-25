/*
 *  Company: RS
 *  Project: spring-crm-rest
 *  Created: 25 sty 2022  12:54:21
 *  Author:  RS 		
 */
package pl.rsof.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.rsof.springdemo.entity.Customer;
import pl.rsof.springdemo.service.CustomerService;

/**
 * <p></p><p>25 sty 2022</p>
 * @author RS
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {

	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List<Customer>getCustomers(){
		return customerService.getCustomers();
	}
	
	
}