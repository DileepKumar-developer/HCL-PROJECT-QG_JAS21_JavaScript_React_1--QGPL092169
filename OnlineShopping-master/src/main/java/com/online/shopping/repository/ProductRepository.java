package com.online.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
