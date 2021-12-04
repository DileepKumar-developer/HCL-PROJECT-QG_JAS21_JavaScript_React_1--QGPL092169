package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.groceryStore.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}

