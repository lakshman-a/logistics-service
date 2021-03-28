package com.logistics.hennex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistics.hennex.modal.Docket;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
//JpaRepository
//@Repository
//public interface UserRepository extends CrudRepository<User, Integer> {
//
//}

@Repository
public interface DocketRepository extends JpaRepository<Docket, Long> {
public List<Docket> findByShipment(String shipmentId);
}