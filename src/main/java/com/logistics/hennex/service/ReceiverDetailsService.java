package com.logistics.hennex.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Receiver;
import com.logistics.hennex.repository.ReceiverRepository;

@Service
public class ReceiverDetailsService {
	@Autowired
	private ReceiverRepository receiverRepository;

	public List<Receiver> getAllReceivers() {
		return receiverRepository.findAll();
	}

	public Receiver createReceiver(Receiver receiver) {
		receiver.setUpdatedBy(receiver.getCreatedBy());
		return receiverRepository.save(receiver);
	}

	public Receiver getReceiverById(Long receiverID) {
		return receiverRepository.findById(receiverID)
				.orElseThrow(() -> new ResourceNotFoundException("Receiver", "id", receiverID));
	}

	public Receiver updateReceiver(Long receiverID, Receiver receiver) {
//		return receiverRepository.save(customer);
		receiverRepository.findById(receiverID)
				.orElseThrow(() -> new ResourceNotFoundException("Receiver", "id", receiverID));
		receiver.setReceiverID(receiverID);
		Receiver updatedReceiver = receiverRepository.save(receiver);
		return updatedReceiver;
	}
	
	public boolean updateAddressForRecipient(Long receiverID,long addressId) {
//		return receiverRepository.save(customer);
		Receiver receiver = receiverRepository.findById(receiverID)
				.orElseThrow(() -> new ResourceNotFoundException("Receiver", "id", receiverID));
		receiver.setAddressId(addressId);
		receiverRepository.save(receiver);
		return true;
	}

	public boolean deleteReceiver(Long receiverID) {
//		Customer customer = receiverRepository.findById(customerID)
//				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerID));

//		receiverRepository.delete(customer);
		if (receiverRepository.findById(receiverID).isPresent()) {
			receiverRepository.deleteById(receiverID);
			return true;
		} else {
			return false;
		}
	}
	
//	public static void main(String[] args) {
//		String[] test = {"test1","test2","test3"};
//		System.out.println(Arrays.toString(test));
//		}
}
