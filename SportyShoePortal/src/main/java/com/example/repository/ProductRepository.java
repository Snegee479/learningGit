package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.Product;
@Repository

public interface ProductRepository extends JpaRepository <Product,Integer>{
	

}
