package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pojo.Buyer;
import com.example.repository.BuyerRepository;

@Component
public class BuyerDAO {
	@Autowired(required=true)
	BuyerRepository buyerRepository;
	
	public Buyer insert(Buyer buyer) {
		return buyerRepository.save(buyer);
	}
	public List<Buyer> getAllBuyers(){
		return buyerRepository.findAll();
	}
	public Buyer findByEmail(String email) {
		return buyerRepository.findByEmail(email);
	}
}
