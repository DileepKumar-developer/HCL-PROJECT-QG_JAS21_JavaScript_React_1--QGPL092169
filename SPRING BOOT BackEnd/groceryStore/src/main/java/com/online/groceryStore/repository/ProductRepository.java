package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;

import com.online.groceryStore.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
