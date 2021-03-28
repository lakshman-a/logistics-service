package com.logistics.hennex.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Sender;
import com.logistics.hennex.repository.SenderRepository;

@Service
public class SenderDetailService {
	@Autowired
	private SenderRepository senderRepository;

	public List<Sender> getAllSenders() {
		return senderRepository.findAll();
	}

	public Sender createSender(Sender sender) {
		sender.setUpdatedBy(sender.getCreatedBy());
		return senderRepository.save(sender);
	}

	public Sender getSenderById(Long senderID) {
		return senderRepository.findById(senderID)
				.orElseThrow(() -> new ResourceNotFoundException("Sender", "id", senderID));
	}

	public Sender updateSender(Long senderID, Sender sender) {
//		return senderRepository.save(customer);
		senderRepository.findById(senderID)
				.orElseThrow(() -> new ResourceNotFoundException("Sender", "id", senderID));
		sender.setSenderID(senderID);
		Sender updatedSender = senderRepository.save(sender);
		return updatedSender;
	}
	
	public boolean updateShipmentForSender(Long senderID, String[] shipmentIds) {
//		return senderRepository.save(customer);
		Sender sender = senderRepository.findById(senderID)
				.orElseThrow(() -> new ResourceNotFoundException("Sender", "id", senderID));
		sender.setActiveShipments(String.join(",", shipmentIds));
		senderRepository.save(sender);
		return true;
	}

	public boolean deleteSender(Long senderID) {
//		Customer customer = senderRepository.findById(customerID)
//				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerID));

//		senderRepository.delete(customer);
		if (senderRepository.findById(senderID).isPresent()) {
			senderRepository.deleteById(senderID);
			return true;
		} else {
			return false;
		}
	}
	
//	public static void main(String[] args) {
//		String[] test = {"test1","test2","test3"};
//		System.out.println(String.join(",", test));
//		}
}
