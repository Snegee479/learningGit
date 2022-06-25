package com.example.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
@Entity
public class Admin {
	@Id
	@Email
	private String email;
	private String name;
	private String password;
}
