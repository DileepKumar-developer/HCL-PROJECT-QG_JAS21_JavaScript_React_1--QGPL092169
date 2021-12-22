package com.online.groceryStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.groceryStore.model.Product;
import com.online.groceryStore.service.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public List<Product> findAll(){
		return productService.viewAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getOne(@PathVariable("id") Integer productId) {
		return productService.viewProduct(productId);
	}
	@PostMapping(value = "/create",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Product> createNew(@RequestBody Product product ) {
		productService.addProduct(product);
		return ResponseEntity.ok(product);
	}
	@PutMapping("/{id}/update")
    public ResponseEntity edit(@PathVariable("id") Integer productId,
                               @RequestBody Product product) {
		product.setProductId(productId); 
        return ResponseEntity.ok(productService.updateProduct(product));
    }
	@DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") Integer productId) {
        productService.removeProduct(productId);
        return ResponseEntity.ok().build();
    }
	
	
}
