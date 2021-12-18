package com.online.shopping.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.entity.Category;
import com.online.shopping.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	@Transactional
	public Category findCategoryById(Integer id) {
		return categoryRepository.findById(id).get();
	}
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}
}
