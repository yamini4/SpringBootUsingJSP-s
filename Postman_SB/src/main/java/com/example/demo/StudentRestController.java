package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

	@Autowired
	StudentDao dao;
	
	@PostMapping("/insert")
	public Student insert(@RequestBody Student s) {
		return dao.insert(s);
	}
	@PostMapping("/insertall")
	public List<Student> insertAll(@RequestBody List<Student> s){
		return dao.insertAllStudents(s);
	}
	
	
	
	@GetMapping("/getall")
	public List<Student> getallStudents(){
		List<Student> students=dao.getall();
		return students;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return dao.deleteByid(id);
	}
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student s) {
		return dao.update(s);
	}
	
	@GetMapping("/getbyname/{name}")
	public Student findStudent(@PathVariable String name) {
		return dao.findbyname(name);
	}
}
