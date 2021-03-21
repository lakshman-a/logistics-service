package com.logistics.hennex.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Customer;
import com.logistics.hennex.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer createCustomer(Customer customer) {
		customer.setUpdatedBy(customer.getCreatedBy());
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(Long customerID) {
		return customerRepository.findById(customerID)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerID));
	}

	public Customer updateCustomer(Long customerId, Customer customer) {
//		return customerRepository.save(customer);
		customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
		customer.setCustomerID(customerId);
		Customer updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;
	}

	public boolean deleteCustomer(Long customerID) {
//		Customer customer = customerRepository.findById(customerID)
//				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerID));

//		customerRepository.delete(customer);
		if (customerRepository.findById(customerID).isPresent()) {
			customerRepository.deleteById(customerID);
			return true;
		} else {
			return false;
		}
	}
}
