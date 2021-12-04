package com.online.groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.groceryStore.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
