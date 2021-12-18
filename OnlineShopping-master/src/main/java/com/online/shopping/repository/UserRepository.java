package com.online.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.shopping.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
