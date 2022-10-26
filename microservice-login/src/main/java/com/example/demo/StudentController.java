package com.example.demo;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class StudentController {

	@Autowired
	StudentDao dao;
	RestTemplate temp=new RestTemplate();
	
	Logger logger=Logger.getAnonymousLogger();
	
	@ResponseBody
	@RequestMapping("/Login")
	public String checkLogin(HttpServletRequest req,HttpServletResponse res) {
		String user=req.getParameter("user");
		logger.info("inside the login microservice controller of login request");
		if(dao.findByUser(user)!=null) {
			logger.info("verified the credentials");
			return "Login is successfull\nWelcome to the"+user;
		}else {
			logger.info("login failed");
			return "check the credentials (or) Register first";
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public String msOfRegister(HttpServletRequest req,HttpServletResponse res) {
		logger.info("entered into login ms with the request as register");
		String suser=req.getParameter("user");
		String spassword =req.getParameter("pwd");
		String email=req.getParameter("email");
		String url="http://localhost:8081/register-user/"+suser+"/"+spassword+"/"+email;
		logger.info(url);
		temp.getForObject(url,String.class);
		logger.info("successfully went to register microservice");
		return "Success";
	}
}
