package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String name;
	private String email;
	
}
