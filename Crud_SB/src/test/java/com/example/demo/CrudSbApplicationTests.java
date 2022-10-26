package com.example.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CrudSbApplicationTests {

	@Autowired
	StudentRepo repo;
	
	@Test
	public void test() {
		System.out.println("inside the test method");
		Student student=new Student();
		student.setName("prameela");
		student.setEmail("p@p.com");
		assertNotNull(repo.save(student));
	}
}
