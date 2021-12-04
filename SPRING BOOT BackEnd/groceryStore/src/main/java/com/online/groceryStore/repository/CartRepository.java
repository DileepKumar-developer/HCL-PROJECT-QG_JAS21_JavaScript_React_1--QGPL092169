package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.groceryStore.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
