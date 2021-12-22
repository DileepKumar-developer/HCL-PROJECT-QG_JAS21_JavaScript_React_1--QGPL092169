
package com.online.groceryStore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.groceryStore.model.Product;
import com.online.groceryStore.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> viewAllProducts(){
		return productRepo.findAll();
	}
	
	public Product addProduct(Product product) {
		return productRepo.save(product); 
	}
	
	@Transactional
	public Product viewProduct(Integer id) {
		Optional<Product> product = productRepo.findById(id);
		return product.get();
	}
	
	public void removeProduct(Integer id) {
		productRepo.deleteById(id);
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	/*public List<Product> viewProductByCategory(String categoryName){
		List<Product> listAll = viewAllProducts();
		return listAll.stream().filter( product -> product.getCategory().getCategoryName().equals(categoryName) ).collect(Collectors.toList());
	}*/
	
}