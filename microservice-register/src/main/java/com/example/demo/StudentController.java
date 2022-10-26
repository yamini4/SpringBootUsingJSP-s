package com.example.demo;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

	@Autowired
	StudentDao dao;
	
	Logger log=Logger.getAnonymousLogger();
	
	@ResponseBody
	@RequestMapping("/register-user/{suser}/{spassword}/{email}")
	public String createStudent(HttpServletRequest req,HttpServletResponse res,
			@PathVariable("suser")String user,@PathVariable("spassword")String pwd,@PathVariable("email")String email) {
				
		
		log.info("entered into the ms of register");
		Student student=new Student();
		student.setSuser(user);
		student.setSpassword(pwd);
		student.setEmail(email);
		log.info("data setter is done");
		
		Student ss=dao.insert(student);
		log.info("insertion done and stored in ss obj"+ss.getSuser()+"  "+ss.getSpassword()+" "+ss.getEmail());
		
		
		return "registration done";
		
	}
}
