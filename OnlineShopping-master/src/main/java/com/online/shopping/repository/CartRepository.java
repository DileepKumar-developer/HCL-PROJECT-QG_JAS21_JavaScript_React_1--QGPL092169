package com.online.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.shopping.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
