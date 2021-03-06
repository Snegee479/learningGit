package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BuyerRepository extends JpaRepository<Buyer,String>{
	public Buyer findByEmail(String email);
}
