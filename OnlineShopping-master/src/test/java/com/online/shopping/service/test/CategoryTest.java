package com.online.shopping.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.online.shopping.entity.Category;
import com.online.shopping.entity.Product;
import com.online.shopping.service.CategoryService;
import com.online.shopping.service.ProductService;

@SpringBootTest
class CategoryTest {

	@Autowired
	private CategoryService categoryService;
	
	@Test
	void createCategoryTest() {
		
		Category category = new Category("Dress");
		Category saveCategory = categoryService.addCategory(category);
		assertEquals(category.getCatId(), saveCategory.getCatId());
	}
	
	
	@Test
	void updateCategorysTest() {
		Category category = categoryService.findCategoryById(1);
		category.setCategoryName("Wearables");
		Category updatedCategory = categoryService.updateCategory(category);
		assertEquals(category.getCategoryName(), updatedCategory.getCategoryName());
	}

}
