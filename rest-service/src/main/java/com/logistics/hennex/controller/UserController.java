package com.logistics.hennex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
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
import com.logistics.hennex.modal.User;
import com.logistics.hennex.repository.UserRepository;

@RestController
//@Component
@RequestMapping(path = "/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	// Get All Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Create a new User
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User note) {
		return userRepository.save(note);
	}

	// Get a Single User
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Long noteId) {
		return userRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("User", "id", noteId));
	}

	// Update a User
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Long noteId, @Valid @RequestBody User userDetails) {

		User user = userRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", noteId));

		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setActive(userDetails.getActive());

		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	// Delete a User
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long noteId) {
		User note = userRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", noteId));

		userRepository.delete(note);

		return ResponseEntity.ok().build();
	}

}
