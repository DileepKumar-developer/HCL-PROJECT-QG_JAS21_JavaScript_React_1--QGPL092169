package com.online.groceryStore.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.groceryStore.model.User;
import com.online.groceryStore.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User addNewUser(User user) {
		return userRepository.save(user);
	}
	
	public String viewUserRole(Integer id) {
		return userRepository.findById(id).get().getRole();
	}
	public String viewUserName(Integer id) {
		return userRepository.findById(id).get().getUsername();
	}
	public List<String> viewUser(Integer id){
		List<String> userData = new ArrayList<>();
		userData.add(viewUserName(id));
		userData.add(viewUserRole(id));
		return userData;
	}
	public List<List<String>> viewAllUsers(){
		List<User> allUsers = userRepository.findAll();
		List<List<String>> userData = new ArrayList<>();
		for( User user : allUsers ) {
			userData.add(viewUser(user.getUserId()));
		}
		return userData;
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	public void removeUser(Integer id) {
		userRepository.deleteById(id);
	}
	
}
