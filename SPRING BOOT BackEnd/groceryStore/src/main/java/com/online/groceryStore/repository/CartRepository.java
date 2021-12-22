package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.online.groceryStore.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
