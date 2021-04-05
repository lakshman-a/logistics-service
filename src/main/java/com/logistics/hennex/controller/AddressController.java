package com.logistics.hennex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logistics.hennex.modal.Address;
import com.logistics.hennex.service.AddressService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class AddressController {
	@Autowired
	private AddressService addressService;

	// Get All address
	@GetMapping("/address")
	public ResponseEntity<?>  getAlladdress() {
		return ResponseEntity.ok(addressService.getAllAddress());
	}

	// Create a new Address
	@PostMapping("/address")
	public Address createAddress(@Valid @RequestBody Address address,@RequestParam(name = "sender") String senderId) {
		return addressService.createAddress(Long.valueOf(senderId),address);
	}

	// Get a Single Address
	@GetMapping("/address/{id}")
	public Address getAddressById(@PathVariable(value = "id") Long addressId) {
	//	return addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address", "id", addressId));
		return addressService.getAddressById(addressId);
	}

	// Update a Address
	@PutMapping("/address/{id}")
	public Address updateAddress(@PathVariable(value = "id") Long addressId, @Valid @RequestBody Address AddressDetails) {
		return addressService.updateAddress(addressId,AddressDetails);
	}

	// Delete a Address
	@DeleteMapping("/address/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "id") Long addressId) {
		if(addressService.deleteAddress(addressId)){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

}
