package com.online.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.shopping.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}
