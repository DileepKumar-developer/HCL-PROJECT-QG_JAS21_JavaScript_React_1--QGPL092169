package com.online.shopping.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.entity.Customer;
import com.online.shopping.repository.AddressRepository;
import com.online.shopping.repository.CustomerRepository;
import com.online.shopping.entity.Cart;
import com.online.shopping.entity.Address;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	public List<Customer> viewAllCustomers(){
		return customerRepository.findAll();
	}

	public Customer viewCustomer(Integer id) {
		return customerRepository.findById(id).get();
	}
	public void removeCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	public void removeCustomerById(Integer customerId) {
		customerRepository.deleteById(customerId);;
	}
	public Customer addCustomer(Customer customer) {
		Cart cart = new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);
		return customerRepository.save(customer);
	}
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public Address addAddress(Integer customerId,Integer addressId) {
		Address address = addressRepository.findById(addressId).get();
		Customer customer = customerRepository.findById(customerId).get();
		customer.setAddress(address);
		address.setCustomer(customer);
		addressRepository.save(address);
		return address;
	}
}
