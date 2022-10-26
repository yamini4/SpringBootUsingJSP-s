package com.example.demo;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	ProductRepository repository;
	@Autowired
	CategoryRepository cRepository;
	
	@GetMapping("pgetall")
	public ModelAndView getAllProducts() {
		ModelAndView mv= new ModelAndView();
		List<Product> list=repository.findAll();
		mv.setViewName("product_display.jsp");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("pinsert")
	public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		
		Product product=new Product();
		product.setName(req.getParameter("name"));
		product.setDescription(req.getParameter("description"));
		product.setPrice(req.getParameter("price"));
		
		product.setCategory_id(req.getParameter("cid"));
		Product product2= repository.save(product);
		if(product2!=null) {
			mv.setViewName("product_add.jsp");
		}
		return mv;
	}
	@RequestMapping("pupdate")
	public ModelAndView update(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		
		@SuppressWarnings("deprecation")
		Product product=repository.getById(Integer.parseInt(req.getParameter("id")));
		product.setName(req.getParameter("name"));
		product.setDescription(req.getParameter("description"));
		product.setPrice(req.getParameter("price"));	
		product.setCategory_id(req.getParameter("cid"));
		Product p1= repository.save(product);
		if(p1!=null) {
		List<Product> list=repository.findAll();
		mv.setViewName("product_display.jsp");
		mv.addObject("list",list);
		}else {
			mv.setViewName("product_edit.jsp");
			mv.addObject("error","some thing is missing try again");
		}
		return mv;
	}
	@GetMapping("pdelete")
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();

		repository.deleteById(Integer.parseInt(req.getParameter("id")));
		List<Product> list=repository.findAll();
		mv.setViewName("product_display.jsp");
		mv.addObject("list",list);
		return mv;
	}
}
