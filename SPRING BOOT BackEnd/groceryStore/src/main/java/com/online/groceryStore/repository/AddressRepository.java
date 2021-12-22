package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.groceryStore.model.Address;
import org.springframework.stereotype.Repository;
@Repository

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}
