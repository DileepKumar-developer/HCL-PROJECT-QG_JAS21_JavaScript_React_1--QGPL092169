package com.online.shopping.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String productName;
	
	private double price;
	
	private String color;
	
	private String dimension;
	
	private String specification;
	
	private String manufacturer;
	
	private int quantity;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,cascade = {
			CascadeType.PERSIST,CascadeType.MERGE
	})
	@JoinTable(name="products_carts",joinColumns = {
			@JoinColumn(name="product_id",referencedColumnName = "productId")},
	inverseJoinColumns = {@JoinColumn(name="cart_id",referencedColumnName ="cartId")  })
	private Set<Cart> carts = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,cascade = {
			CascadeType.PERSIST,CascadeType.MERGE
	})
	@JoinTable(name="products_orders",joinColumns = {
			@JoinColumn(name="prodcut_id",referencedColumnName = "productId")},
	inverseJoinColumns = {@JoinColumn(name="order_id",referencedColumnName ="orderId")  })
	private Set<Order> orders = new HashSet<>();
	
	public Product() {
	}

	public Product(String productName, double price, String color, String dimension,
			String specification, String manufacturer, int quantity) {
//		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCart(Cart cart) {
		this.carts.add(cart);
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public void setOrder(Order order) {
		this.orders.add(order);
	}
}
