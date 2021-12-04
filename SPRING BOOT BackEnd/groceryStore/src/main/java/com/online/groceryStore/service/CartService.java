package com.online.groceryStore.service;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.groceryStore.model.Cart;
import com.online.groceryStore.model.Customer;
import com.online.groceryStore.model.Product;
import com.online.groceryStore.repository.CustomerRepository;
import com.online.groceryStore.repository.ProductRepository;

@Service
public class CartService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	public Cart getCustomerCart(Integer customerId ) {
		Customer customer = customerRepository.findById(customerId).get();
		Cart cart = customer.getCart();
		return cart;
	}
	
	public Cart addProductToCart(Integer productId,Integer customerId) {
		Product product = productRepository.findById(productId).get();
		Customer customer = customerRepository.findById(customerId).get();
		Cart cart = customer.getCart();
		cart.setProduct(product);
		product.setCart(cart);
		customer.setCart(cart);
		customerRepository.save(customer);
		productRepository.save(product);
		return cart;
	}
	
	public void removeProductFromCart( Integer customerId, Integer productId ) {
		Customer customer = customerRepository.findById(customerId).get();
		Product product = productRepository.findById(productId).get();
		Cart cart = customer.getCart();
		product.getCarts().remove( cart );
		cart.getProducts().remove(product);		
		customer.setCart(cart);
		productRepository.save(product);
		customerRepository.save(customer);
	}
	
	public void removeAllProducts(Integer customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		Cart cart = customer.getCart();
		Set<Product> productsInCart = cart.getProducts();
		for(Product product : productsInCart  ) {
			product.getCarts().remove(cart);
		}
		cart.setProducts(new HashSet<Product>());
		customer.setCart(cart);
		customerRepository.save(customer);
	}
	
}

