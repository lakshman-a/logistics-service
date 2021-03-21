package com.logistics.hennex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Customer;
import com.logistics.hennex.repository.CustomerRepository;

//@Service
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RestController
//@RequestMapping(path = "/api")
//public class CustomerServiceController {
//	@Autowired
//	private CustomerRepository customerRepository;
//
//	@GetMapping("/customers")
//	public List<Customer> getAllCustomers() {
//		return customerRepository.findAll();
//	}
//
//	@PostMapping("/customers")
//	public Customer createCustomer(@Valid @RequestBody Customer customer) {
//		return customerRepository.save(customer);
//	}
//
//	@GetMapping("/customers/{id}")
//	public Customer getCustomerById(@PathVariable(value = "id") Long customerId) {
//		return customerRepository.findById(customerId)
//				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
//	}
//
//	@PutMapping("/customers/{id}")
//	public Customer updateCustomer(@PathVariable(value = "id") Long customerId, @Valid @RequestBody Customer CustomerDetails) {
//		return customerRepository.save(CustomerDetails);
////		Customer Customer = customerRepository.findById(noteId)
////				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", noteId));
//////
//////		Customer.setFirstName(CustomerDetails.getFirstName());
//////		Customer.setLastName(CustomerDetails.getLastName());
//////		Customer.setActive(CustomerDetails.getActive());
////
////		Customer updatedCustomer = customerRepository.save(Customer);
////		return updatedCustomer;
//	}
//
//	@DeleteMapping("/customers/{id}")
//	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long customerId)  {
////		Customer customer = customerRepository.findById(customerID)
////				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerID));
//		customerRepository.deleteById(customerId);
////		customerRepository.delete(customer);
//
//		return ResponseEntity.noContent().build();
//	}
//}
