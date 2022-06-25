package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class CategoryDAO {
	
	@Autowired
	CategoryRepository repo;
	
	public Category insert(Category category) {
		return (Category) repo.save(category);
	}
	public Category findByCategoryId(int categoryId) {
		return (Category)repo.findByCategoryId(categoryId);
	}
	public List<Category> getAll() {
		return repo.findAll();
	}
	public String deleteById(int id) {
		repo.deleteById(id);
		return "deleted the id value:"+id; 
	}
	public Category update(Category category) {
		Category existingCategory=(Category) repo.findById(category.getCategoryId()).orElse(null);
		existingCategory.setCategoryName(category.getCategoryName());
		return (Category) repo.save(existingCategory);
	}
	
}
