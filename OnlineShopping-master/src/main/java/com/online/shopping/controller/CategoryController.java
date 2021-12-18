package com.online.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.entity.Address;
import com.online.shopping.entity.Category;
import com.online.shopping.entity.Product;
import com.online.shopping.service.CartService;
import com.online.shopping.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public List<Category> findAll(){
		return categoryService.findAll();
	}
	@GetMapping("/{id}")
	public Category getOne(@PathVariable("id") Integer catId) {
		return categoryService.findCategoryById(catId);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Category> createNew( @RequestBody Category category ){
		categoryService.addCategory(category);
		return ResponseEntity.ok(category);
	}
	@PutMapping("/{id}/update")
    public String edit(@PathVariable("id") Integer categoryId,
                               @RequestBody Category category) {
		category.setCatId(categoryId);
		categoryService.updateCategory(category);
        return category.getCategoryName()+" is updated" ;
    }
	@DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") Integer categoryId) {
        categoryService.deleteCategory( categoryService.findCategoryById(categoryId)  );
        return ResponseEntity.ok().build();
    }
	
	
	
	
}
