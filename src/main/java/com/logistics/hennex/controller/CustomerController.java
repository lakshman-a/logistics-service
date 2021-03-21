package com.logistics.hennex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Customer;
import com.logistics.hennex.repository.CustomerRepository;
import com.logistics.hennex.service.CustomerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	// Get All Customers
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	// Create a new Customer
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	// Get a Single Customer
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") Long customerId) {
	//	return customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
		return customerService.getCustomerById(customerId);
	}

	// Update a Customer
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@PathVariable(value = "id") Long customerId, @Valid @RequestBody Customer CustomerDetails) {
		return customerService.updateCustomer(customerId,CustomerDetails);
	}

	// Delete a Customer
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long customerId) {
		if(customerService.deleteCustomer(customerId)){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

}
