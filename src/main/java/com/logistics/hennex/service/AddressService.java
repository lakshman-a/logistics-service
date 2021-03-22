package com.logistics.hennex.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Address;
import com.logistics.hennex.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	public Address createAddress(Address address) {
		address.setUpdatedBy(address.getCreatedBy());
		return addressRepository.save(address);
	}

	public Address getAddressById(Long addressID) {
		return addressRepository.findById(addressID)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "id", addressID));
	}

	public Address updateAddress(Long addressId, Address address) {
		addressRepository.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "id", addressId));
		address.setAddressId(addressId);
		Address updatedAddress = addressRepository.save(address);
		return updatedAddress;
	}

	public boolean deleteAddress(Long addressID) {
//		Address address = addressRepository.findById(addressID)
//				.orElseThrow(() -> new ResourceNotFoundException("Address", "id", addressID));

//		addressRepository.delete(address);
		if (addressRepository.findById(addressID).isPresent()) {
			addressRepository.deleteById(addressID);
			return true;
		} else {
			return false;
		}
	}
}
