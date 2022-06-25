package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseListDAO {
	@Autowired
	PurchaseListRepository repo;
	public PurchaseList insert(PurchaseList p) {
		return (PurchaseList) repo.save(p);
	}
	public List<PurchaseList> getAll() {
		return repo.findAll();
	}
	public String deleteById(int id) {
		repo.deleteById(id);
		return "deleted the id value:"+id; 
	}
	public PurchaseList update(PurchaseList p) {
		PurchaseList existingPurchaseList= repo.findById(p.getProductId()).orElse(null);
		existingPurchaseList.setProductName(p.getProductName());
		existingPurchaseList.setProductPrice(p.getProductPrice());
		existingPurchaseList.setProductDescription(p.getProductDescription());
		existingPurchaseList.setCategory(p.getCategory());
		existingPurchaseList.setAddress(p.getAddress());
		return (PurchaseList) repo.save(existingPurchaseList);
	}
}
