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

import com.logistics.hennex.modal.Docket;
import com.logistics.hennex.service.DocketService;
import com.logistics.hennex.service.ShipmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class DocketController {
	@Autowired
	private DocketService docketService;
	@Autowired
	private ShipmentService shipmentService;

	// Get All Dockets
	@GetMapping("/docket")
	public List<Docket> getAllDockets() {
		return docketService.getAllDocket();
	}
	
	// Get a Single Docket
	@GetMapping("/docket/{id}")
	public Docket getDocketById(@PathVariable(value = "id") Long docketId) {
	//	return docketRepository.findById(docketId).orElseThrow(() -> new ResourceNotFoundException("Docket", "id", docketId));
		return docketService.getDocketById(docketId);
	}

	// Create a new Docket
	@PostMapping("/docket")
	public Docket createDocket(@Valid @RequestBody Docket docket,@RequestParam(name="shipment")String shipmentId) {
		Docket tmpDocket =docketService.createDocket(shipmentId,docket);
		shipmentService.updateWtVolForShipment(shipmentId);
		return tmpDocket;
	}

	// Update a Docket
	@PutMapping("/docket/{id}")
	public Docket updateDocket(@PathVariable(value = "id") Long docketId, @Valid @RequestBody Docket DocketDetails) {
		Docket tmpDocket = docketService.updateDocket(docketId,DocketDetails);
		shipmentService.updateWtVolForShipment(DocketDetails.getShipmentId());
		return tmpDocket;
	}

	// Delete a Docket
	@DeleteMapping("/docket/{id}")
	public ResponseEntity<?> deleteDocket(@PathVariable(value = "id") Long docketId) {
		String shipmentID = docketService.getDocketById(docketId).getShipmentId();
		if(docketService.deleteDocket(docketId)){		
			shipmentService.updateWtVolForShipment(shipmentID);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

}
