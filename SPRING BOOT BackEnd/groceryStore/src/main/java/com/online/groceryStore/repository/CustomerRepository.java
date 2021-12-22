package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.groceryStore.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
