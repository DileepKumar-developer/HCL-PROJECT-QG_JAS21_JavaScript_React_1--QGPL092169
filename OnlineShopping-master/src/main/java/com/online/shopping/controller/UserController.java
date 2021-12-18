package com.online.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.entity.Customer;
import com.online.shopping.entity.User;
import com.online.shopping.repository.UserRepository;
import com.online.shopping.service.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public List<List<String>> findAll(){
		return userService.viewAllUsers();
	}
	
	@GetMapping("/{id}")
	public List<String> findUser(@PathVariable("id") Integer id){
		return userService.viewUser(id);
	}
	
	@PostMapping(value = "/create",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<String> createUser(@RequestBody User user) {
		userService.addNewUser(user);
		return userService.viewUser(user.getUserId());
	}
	
	@PutMapping(value = "/{id}/update",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<String> updateUser(@RequestBody User user,@PathVariable("id") Integer id) {
		user.setUserId(id);
		userService.updateUser(user);
		return userService.viewUser(user.getUserId());
	}
	
	@DeleteMapping(value="/{id}/delete")
	public String deleteUser(@PathVariable("id") Integer id) {
		String username = userService.viewUserName(id);
		userService.removeUser(id);
		return "User with username "+username+" is deleted";
	}
	
}
