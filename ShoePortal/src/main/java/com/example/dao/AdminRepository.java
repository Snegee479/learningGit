package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdminRepository extends JpaRepository<Admin,String> {
	public Admin findByPassword(String password);
	public Admin findByEmail(String email);
		
	}

