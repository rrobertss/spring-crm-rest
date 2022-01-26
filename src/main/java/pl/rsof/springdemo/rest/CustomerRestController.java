/*
 *  Company: RS
 *  Project: spring-crm-rest
 *  Created: 25 sty 2022  12:54:21
 *  Author:  RS 		
 */
package pl.rsof.springdemo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Optional<Customer>optionalCustomer = Optional.ofNullable(customerService.getCustomer(customerId));
		if (optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		else {
			throw new CustomerNotFoundException("Customer not found, id: " + customerId);
		}
	}
	
	
	// mapping for POST / customers - add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		// force to add (insert) customer - null or zero for DAO
		customer.setId(0);
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	
	// mapping for POST / customers - update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {

		customerService.saveCustomer(customer);

		return customer;
	}
	
	
	// mapping for DELETE / customers/{customerId} - delete customer
	@DeleteMapping("customer/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found, id: " + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer, id: "+customerId;
	}
	
	
}
