package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.Buyer;
@Repository
public interface BuyerRepository extends JpaRepository<Buyer,String>{
	public Buyer findByEmail(String email);
}
