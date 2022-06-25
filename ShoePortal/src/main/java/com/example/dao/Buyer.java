package com.example.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity
public class Buyer {
	
	private String firstName;
	private String lastName;
	@Id
	@Email
	private String email;
	private String password;
}
