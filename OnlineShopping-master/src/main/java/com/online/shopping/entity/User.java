package com.online.shopping.entity;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String username;
	private String password;
	private String role;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="users_customers",joinColumns = {
			@JoinColumn(name="user_ids",referencedColumnName = "userId")
	},
	inverseJoinColumns = {
			@JoinColumn(name="customer_ids",referencedColumnName = "customerId")
	})
	private Customer customer;
	
	public User() {
		
	}
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
