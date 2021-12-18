package com.online.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.shopping.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
