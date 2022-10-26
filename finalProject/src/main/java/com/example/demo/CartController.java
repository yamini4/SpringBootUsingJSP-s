package com.example.demo;

import java.util.ArrayList;
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
public class CartController {

	@Autowired
	CartRepository cartRepo;
	@Autowired
	ProductRepository prepo;
	@Autowired
	CategoryRepository crepo;
	
	@RequestMapping("/deleteall")
	public ModelAndView deleteallinAndViewCart(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		cartRepo.deleteAll();
		
		List<Category> list=crepo.findAll();
		mv.addObject("clist", list);
		String id=req.getParameter("id");
		List<Product> pList=prepo.findByCategoryid(id);
		mv.addObject("plist",pList);
		mv.setViewName("user_main.jsp");
		return mv;
	}
	@PostMapping("/add")
	public ModelAndView addCart(HttpServletRequest req,HttpServletResponse res) {
		int pid=Integer.parseInt(req.getParameter("pid"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		double price=Double.parseDouble(req.getParameter("price"));
		Cart cart=new Cart();
		cart.setProduct_id(pid);
		cart.setQuantity(quantity);
		cart.setT_price(price);
		cartRepo.save(cart);
		
		ModelAndView mv=new ModelAndView();
	    List<Category> list=crepo.findAll();
		mv.addObject("clist", list);
		String id=req.getParameter("id");
		List<Product> pList=prepo.findByCategoryid(id);
		mv.addObject("plist",pList);
		mv.setViewName("user_main.jsp");
		return mv;
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("/getcart")
	public ModelAndView getAllCartItems() {
		ModelAndView mv = new ModelAndView();
		List<Cart> carts=cartRepo.findAll();
		double sum=0;		
		
		List<Product> products=new ArrayList<>();
		for(Cart c:carts) {
			products.add(prepo.getById(c.getProduct_id()));
			sum=sum+(c.getQuantity()*c.getT_price());
		}
		mv.addObject("total", sum);
		mv.addObject("products", products);
		mv.setViewName("cart_view.jsp");
		return mv;
	}
	@RequestMapping("/home")
	public ModelAndView Home(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		List<Category> list=crepo.findAll();
		mv.addObject("clist", list);
		
		String id=req.getParameter("id");
		List<Product> pList=prepo.findByCategoryid(id);
		mv.addObject("plist",pList);
		mv.setViewName("user_main.jsp");
		return mv;
	}
}
