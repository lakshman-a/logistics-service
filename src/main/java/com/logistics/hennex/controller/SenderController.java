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
import org.springframework.web.bind.annotation.RestController;

import com.logistics.hennex.modal.Sender;
import com.logistics.hennex.service.SenderDetailService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class SenderController {
	@Autowired
	private SenderDetailService senderService;

	// Get All Senders
	@GetMapping("/sender")
	public List<Sender> getAllSenders() {
		return senderService.getAllSenders();
	}
	
	// Get a Single Sender
	@GetMapping("/sender/{id}")
	public Sender getSenderById(@PathVariable(value = "id") Long senderId) {
	//	return senderRepository.findById(senderId).orElseThrow(() -> new ResourceNotFoundException("Sender", "id", senderId));
		return senderService.getSenderById(senderId);
	}

	// Create a new Sender
	@PostMapping("/sender")
	public Sender createSender(@Valid @RequestBody Sender sender) {
		return senderService.createSender(sender);
	}

	// Update a Sender
	@PutMapping("/sender/{id}")
	public Sender updateSender(@PathVariable(value = "id") Long senderId, @Valid @RequestBody Sender SenderDetails) {
		return senderService.updateSender(senderId,SenderDetails);
	}

	// Delete a Sender
	@DeleteMapping("/sender/{id}")
	public ResponseEntity<?> deleteSender(@PathVariable(value = "id") Long senderId) {
		if(senderService.deleteSender(senderId)){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

}
