package com.example.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

	@Data
	@Entity
	public class PurchaseList {
		@Id
		int productId;
		String productName;
		double productPrice;
		String productDescription;
		@ManyToOne(cascade = CascadeType.ALL)  
		@JoinColumn(name="category_id")  
		Category category;
		@ManyToOne(cascade = CascadeType.ALL)  
		@JoinColumn(name="email")  
		Buyer buyer;
		String Address;
		
	}
