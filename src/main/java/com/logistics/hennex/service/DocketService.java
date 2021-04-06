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
import com.logistics.hennex.modal.Docket;
import com.logistics.hennex.repository.DocketRepository;

@Service
public class DocketService {
	@Autowired
	private DocketRepository docketRepository;

	public List<Docket> getAllDocket() {
		return docketRepository.findAll();
	}

	public Docket createDocket(String shipmentId,Docket docket) {
		float volume = 0;
		if (docket.getHeight() > 0 && docket.getLength() > 0 && docket.getBreadth() > 0) {
			volume = docket.getHeight()*docket.getLength()*docket.getBreadth();
		}
		docket.setShipmentId(shipmentId);
		docket.setVolume(volume);
		docket.setUpdatedBy(docket.getCreatedBy());
		return docketRepository.save(docket);
	}

	public Docket getDocketById(Long docketID) {
		return docketRepository.findById(docketID)
				.orElseThrow(() -> new ResourceNotFoundException("Docket", "id", docketID));
	}

	public Docket updateDocket(Long docketId, Docket docket) {
		Docket tmpDocker = docketRepository.findById(docketId)
				.orElseThrow(() -> new ResourceNotFoundException("Docket", "id", docketId));
		docket.setDocketId(docketId);
		docket.setCreatedBy(tmpDocker.getCreatedBy());
		docket.setCreatedOn(tmpDocker.getCreatedOn());
		Docket updatedDocket = docketRepository.save(docket);
		return updatedDocket;
	}

	public boolean deleteDocket(Long docketID) {
//		Docket docket = docketRepository.findById(docketID)
//				.orElseThrow(() -> new ResourceNotFoundException("Docket", "id", docketID));

//		docketRepository.delete(docket);
		if (docketRepository.findById(docketID).isPresent()) {
			docketRepository.deleteById(docketID);
			return true;
		} else {
			return false;
		}
	}
}
