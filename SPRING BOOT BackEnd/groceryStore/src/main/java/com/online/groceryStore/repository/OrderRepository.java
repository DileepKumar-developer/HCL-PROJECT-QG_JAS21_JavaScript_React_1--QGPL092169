package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.groceryStore.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
