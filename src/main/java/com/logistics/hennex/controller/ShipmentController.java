package com.logistics.hennex.controller;

import java.util.List;
import java.util.Map;

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

import com.logistics.hennex.modal.Shipment;
import com.logistics.hennex.service.ShipmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class ShipmentController {
	@Autowired
	private ShipmentService shipmentService;

	// Get All shipment
	@GetMapping("/shipment")
	public ResponseEntity<?> getAllshipment() {
		return ResponseEntity.ok(shipmentService.getAllShipment());
	}

	// Create a new Shipment
	@PostMapping("/shipment")
	public Shipment createShipment(@Valid @RequestBody Shipment shipment, @RequestParam Map<String, String> allParams) {
		return shipmentService.createShipment(allParams, shipment);
	}

	// Get a Single Shipment
	@GetMapping("/shipment/{id}")
	public Shipment getShipmentById(@PathVariable(value = "id") String shipmentId) {
		// return shipmentRepository.findById(shipmentId).orElseThrow(() -> new
		// ResourceNotFoundException("Shipment", "id", shipmentId));
		return shipmentService.getShipmentById(shipmentId);
	}

	@GetMapping("/tracking/{id}")
	public Shipment getShipmentByTrackingId(@PathVariable(value = "id") String trackingId) {
		// return shipmentRepository.findById(shipmentId).orElseThrow(() -> new
		// ResourceNotFoundException("Shipment", "id", shipmentId));
		if (trackingId.toUpperCase().startsWith("HNX")) {
			return shipmentService.getShipmentById(trackingId);
		} else {
			return shipmentService.getShipmentByAwbNo(trackingId);
		}
	}
	
	@GetMapping("/trackAllActiveShipment")
	public List<Shipment> getAllShipmentsByStatus(@RequestParam(name="status")String status) {
		// return shipmentRepository.findById(shipmentId).orElseThrow(() -> new
		// ResourceNotFoundException("Shipment", "id", shipmentId));
		return shipmentService.getAllShipmentByShipmentStatus(status);
	}
	
	@GetMapping("/trackAllShipment")
	public List<Shipment> getAllShipmentsForSender(@RequestParam(name="sender")String senderId) {
		// return shipmentRepository.findById(shipmentId).orElseThrow(() -> new
		// ResourceNotFoundException("Shipment", "id", shipmentId));
		return shipmentService.getAllShipmentBySenderId(Long.valueOf(senderId));
	}

	// Update a Shipment
	@PutMapping("/shipment")
	public Shipment updateShipment(@PathVariable(value = "id") String shipmentId,
			@Valid @RequestBody Shipment ShipmentDetails) {
		return shipmentService.updateShipment(shipmentId, ShipmentDetails);
	}

	// Delete a Shipment
	@DeleteMapping("/shipment/{id}")
	public ResponseEntity<?> deleteShipment(@PathVariable(value = "id") String shipmentId) {
		if (shipmentService.deleteShipment(shipmentId)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
