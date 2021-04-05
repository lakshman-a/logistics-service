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

import com.logistics.hennex.modal.Receiver;
import com.logistics.hennex.service.ReceiverDetailsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class ReceiverController {
	@Autowired
	private ReceiverDetailsService receiverService;

	// Get All receiver
	@GetMapping("/receiver")
	public ResponseEntity<?>  getAllReceiver() {
		return ResponseEntity.ok(receiverService.getAllReceivers());
	}

	// Create a new Address
	@PostMapping("/receiver")
	public Receiver createAddress(@Valid @RequestBody Receiver receiver,@RequestParam(name = "delAddr") String addressId) {
		return receiverService.createReceiver(Long.valueOf(addressId),receiver);
	}

	// Get a Single Address
	@GetMapping("/receiver/{id}")
	public Receiver getAddressById(@PathVariable(value = "id") Long receiverId) {
	//	return receiverRepository.findById(receiverId).orElseThrow(() -> new ResourceNotFoundException("Address", "id", receiverId));
		return receiverService.getReceiverById(receiverId);
	}

	// Update a Address
	@PutMapping("/receiver/{id}")
	public Receiver updateAddress(@PathVariable(value = "id") Long receiverId, @Valid @RequestBody Receiver AddressDetails) {
		return receiverService.updateReceiver(receiverId,AddressDetails);
	}

	// Delete a Address
	@DeleteMapping("/receiver/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "id") Long receiverId) {
		if(receiverService.deleteReceiver(receiverId)){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

}
