package com.logistics.hennex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Sender;
import com.logistics.hennex.modal.Shipment;
import com.logistics.hennex.modal.Docket;
import com.logistics.hennex.repository.DocketRepository;
import com.logistics.hennex.repository.ShipmentRepository;

@Service
public class ShipmentService {
	@Autowired
	private ShipmentRepository shipmentRepository;
	@Autowired
	private DocketRepository docketRepository;

	public List<Shipment> getAllShipment() {
		return shipmentRepository.findAll();
	}

	public Shipment createShipment(Map<String,String> allParams,Shipment shipment) {
		shipment.setShipmentId(Long.toString(System.nanoTime()).substring(9));
		shipment.setUpdatedBy(shipment.getCreatedBy());
		shipment.setSenderID(Long.valueOf(allParams.get("sender")));
		shipment.setPkUpAddrId(Long.valueOf(allParams.get("pkupaddr")));
		shipment.setReceiverId(Long.valueOf(allParams.get("receiver")));
		shipment.setDelAddrId(Long.valueOf(allParams.get("deladdr")));
		return shipmentRepository.save(shipment);
	}

	public Shipment getShipmentById(String shipmentID) {
		return shipmentRepository.findById(shipmentID)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment", "id", shipmentID));
	}

	public Shipment updateShipment(String shipmentId, Shipment shipment) {
		Shipment tmpShipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment", "id", shipmentId));
		shipment.setShipmentId(shipmentId);
		shipment.setCreatedBy(tmpShipment.getCreatedBy());
		shipment.setCreatedOn(tmpShipment.getCreatedOn());
		Shipment updatedShipment = shipmentRepository.save(shipment);
		return updatedShipment;
	}

	public boolean updateWtVolForShipment(String shipmentId) {
//		return senderRepository.save(customer);
		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment", "id", shipmentId));
		// shipment.setDocketIDs(String.join(",", docketIds));
		float totalWeight = 0;
		float totalVolume = 0;
		List<Docket> docketsList = docketRepository.findByShipmentId(shipmentId);
		for(Docket x:docketsList) {
			totalWeight = totalWeight + x.getWeight();
			totalVolume = totalVolume + x.getVolume();
		}
//			for (long i = 0; i < qty - 1; i++) {
//				Docket tmpDocket = docketRepository.findById(docketId)
//						.orElseThrow(() -> new ResourceNotFoundException("Docket", "id", docketId));
//				tmpDocket.setDocketId(null);
//				long dockerid = docketRepository.save(tmpDocket).getDocketId();
//				docketIds = docketIds + "," + String.valueOf(dockerid);
//			}
//		}
		shipment.setTotalWeight(totalWeight);
		shipment.setTotalVolume(totalVolume);
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
