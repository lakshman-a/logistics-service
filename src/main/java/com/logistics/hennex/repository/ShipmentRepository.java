package com.logistics.hennex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistics.hennex.modal.Docket;
import com.logistics.hennex.modal.Shipment;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
//JpaRepository
//@Repository
//public interface UserRepository extends CrudRepository<User, Integer> {
//
//}

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, String> {
	public Shipment findByAwbNo(String awbNo);
	public List<Shipment> findByShipmentStatus(String shipmentStatus);
	public List<Shipment> findBySenderID(long senderId);
}