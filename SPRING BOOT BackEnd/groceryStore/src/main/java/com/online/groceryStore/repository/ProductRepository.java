package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;

import com.online.groceryStore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
