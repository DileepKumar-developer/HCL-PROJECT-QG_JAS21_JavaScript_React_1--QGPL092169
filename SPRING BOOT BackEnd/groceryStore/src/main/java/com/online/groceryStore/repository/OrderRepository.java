package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.groceryStore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
