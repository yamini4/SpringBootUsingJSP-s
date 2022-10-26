package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentDao {

	@Autowired
	StudentRepo repo;
	
	public Student findByUser(String user) {
		return repo.findByUser(user);
	}
	
	/*
	 * public Student findByPassword(String password) { return
	 * repo.findByPassword(password); }
	 */
	
}
