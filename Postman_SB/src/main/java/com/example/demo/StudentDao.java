package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//on the Jpa we have inbuilt methods of insert,delete,select- but we need to
//logically configure update

//all dao operations written under the service
@Service
public class StudentDao {

	@Autowired
	StudentRepo studentRepo;
	
	//insert
	public Student insert(Student s) {
		return studentRepo.save(s);
	}
	
	public List<Student> insertAllStudents(List<Student> s){
		return studentRepo.saveAll(s);
	}
	
	//retrieve
	public List<Student> getall(){
		return studentRepo.findAll();
	}
	
	//delete
	public String deleteByid(int id) {
		studentRepo.deleteById(id);
		return "deleted the id value:"+id;
	}
	
	//update
	//existing table 1 kk k@c.c
	//updating the table 1 pp k@c.c
	public Student update(Student s) {
		Student ss=studentRepo.findById(s.getSid()).orElse(null);
		ss.setName(s.getName());
		ss.setEmail(s.getEmail());
		
		return studentRepo.save(ss);
	}
	//find by name
	public Student findbyname(String name) {
		return studentRepo.findByName(name);
	}
}

