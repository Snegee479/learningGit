package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pojo.Product;
import com.example.repository.ProductRepository;

@Component
public class ProductDAO {
	@Autowired
	ProductRepository repo;
	public Product insert(Product product) {
		return (Product) repo.save(product);
	}
	public List<Product> getAll() {
		return repo.findAll();
	}
	public String deleteById(int id) {
		repo.deleteById(id);
		return "deleted the id value:"+id; 
	}
	public Product update(Product product) {
		Product existingProduct=(Product) repo.findById(product.getProductId()).orElse(null);
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductPrice(product.getProductPrice());
		existingProduct.setProductDescription(product.getProductDescription());
		existingProduct.setCategory(product.getCategory());
		return (Product) repo.save(existingProduct);
	}
}
