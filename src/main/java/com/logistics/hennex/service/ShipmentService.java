package com.logistics.hennex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Sender;
import com.logistics.hennex.modal.Shipment;
import com.logistics.hennex.repository.ShipmentRepository;

@Service
public class ShipmentService {
	@Autowired
	private ShipmentRepository shipmentRepository;

	public List<Shipment> getAllShipment() {
		return shipmentRepository.findAll();
	}

	public Shipment createShipment(Shipment shipment) {
		shipment.setUpdatedBy(shipment.getCreatedBy());
		return shipmentRepository.save(shipment);
	}

	public Shipment getShipmentById(String shipmentID) {
		return shipmentRepository.findById(shipmentID)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment", "id", shipmentID));
	}

	public Shipment updateShipment(String shipmentId, Shipment shipment) {
		shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment", "id", shipmentId));
		shipment.setShipmentId(shipmentId);
		Shipment updatedShipment = shipmentRepository.save(shipment);
		return updatedShipment;
	}
	
	
	public boolean updateDocketsForShipment(String shipmentId, String[] docketIds) {
//		return senderRepository.save(customer);
		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Sender", "id", shipmentId));
		shipment.setDocketIDs(String.join(",", docketIds));
		shipmentRepository.save(shipment);
		return true;
	}
	
	public boolean deleteShipment(String shipmentID) {
//		Shipment shipment = shipmentRepository.findById(shipmentID)
//				.orElseThrow(() -> new ResourceNotFoundException("Shipment", "id", shipmentID));

//		shipmentRepository.delete(shipment);
		if (shipmentRepository.findById(shipmentID).isPresent()) {
			shipmentRepository.deleteById(shipmentID);
			return true;
		} else {
			return false;
		}
	}
}
