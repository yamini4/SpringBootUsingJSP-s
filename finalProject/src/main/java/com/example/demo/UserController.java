package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository crepo;
	
	@GetMapping("ugetall")
	public ModelAndView adding() {
		ModelAndView mv= new ModelAndView();
		List<User> user =userRepository.findAll();
		mv.addObject("user", user);
		mv.setViewName("user_display.jsp");
		return mv;
	}
	
	@PostMapping("uinsert")
	public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv= new ModelAndView();
		User user=new User();
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		user.setUser(req.getParameter("name"));
		user.setPassword(password);
		user.setEmail(req.getParameter("email"));
		user.setGender(req.getParameter("gender"));
		user.setAddress(req.getParameter("address"));
		if(password.equals(cpassword)) {
		userRepository.save(user);
		mv.setViewName("user_add.jsp");
		}else {
			mv.addObject("error","Password Not matching");
			mv.setViewName("user_add.jsp");
		}
		return mv;
	}
	@PostMapping("uedit")
	@SuppressWarnings("deprecation")
	public ModelAndView updateAndView(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		User user=userRepository.getById(req.getParameter("name"));
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		user.setPassword(password);
		user.setEmail(req.getParameter("email"));
		user.setGender(req.getParameter("gender"));
		user.setAddress(req.getParameter("address"));
		if(password.equals(cpassword)) {
			userRepository.save(user);
			List<User> user1 =userRepository.findAll();
		    mv.addObject("user", user1);
		    mv.setViewName("user_display.jsp");
		}
		else {
			mv.addObject("error","Password Not matching");
			mv.setViewName("user_edit.jsp");
		}
		return mv;
	}
	@GetMapping("udelete")
	public ModelAndView deleteAndView(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		String username=req.getParameter("name");
		userRepository.deleteById(username);
		List<User> user1 =userRepository.findAll();
	    mv.addObject("user", user1);
		mv.setViewName("user_display.jsp");
		return mv;
	}
	@GetMapping("cp")
	public ModelAndView getbycid(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv =new ModelAndView();
		
		List<Category> list=crepo.findAll();
		mv.addObject("clist", list);
		
		String id=req.getParameter("id");
		List<Product> pList=productRepository.findByCategoryid(id);
		mv.addObject("plist",pList);
		mv.setViewName("user_main.jsp");
		return mv;
	}
}
