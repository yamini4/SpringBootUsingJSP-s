package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/")
public class CommonController {

	@Autowired
	UserRepository repo;
	@Autowired
	CategoryRepository crepo;
	//@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("login")
	public ModelAndView loginPage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String user= request.getParameter("username");
		String password=request.getParameter("password");
		List<User> l1=repo.findByPassword(password);
		User u1=repo.findById(user).orElseThrow();
		if(l1.contains(u1)) {
			if(user.equalsIgnoreCase("admin")) { 
				mv.setViewName("header.jsp");
				return mv;
			}else {
				List<Category> list=crepo.findAll();
				mv.addObject("clist", list);
				mv.setViewName("user_header.jsp");
				return mv;
			}
		}else {
			mv.addObject("error", "wrong login credentials");
			mv.setViewName("login.jsp");
			return mv;
		}
	}
}