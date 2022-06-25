package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages= {"com.example.Application","com.example.dao","com.example.pojo","com.example.repository"})
public class ShoePortalApplication {

	@Autowired
	CategoryRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(ShoePortalApplication.class, args);
	}

}
