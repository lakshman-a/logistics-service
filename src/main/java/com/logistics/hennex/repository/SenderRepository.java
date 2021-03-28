package com.logistics.hennex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.logistics.hennex.modal.Sender;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
//JpaRepository
//@Repository
//public interface UserRepository extends CrudRepository<User, Integer> {
//
//}

@Repository
public interface SenderRepository extends JpaRepository<Sender, Long> {

}