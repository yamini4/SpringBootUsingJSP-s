package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student, String>{
	
	@Query("Select student from Student student where student.suser=?1")
	public Student findByUser(String user);
	
	/*
	 * @Query("Select student from Student student where student.spassword=?1")
	 * public Student findByPassword(String pwd);
	 */
}
