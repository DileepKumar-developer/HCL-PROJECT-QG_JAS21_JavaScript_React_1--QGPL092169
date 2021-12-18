package com.online.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.shopping.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
