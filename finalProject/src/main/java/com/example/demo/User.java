package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	private String user;
	
	private String password;
	@Transient
	private String confirmPassword;
	
	private String email;
	private String gender;
	private String address;
	
}
