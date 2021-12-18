package com.online.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.shopping.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
