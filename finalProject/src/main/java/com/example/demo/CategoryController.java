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
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("cgetall")
	public ModelAndView getAllCategories() {
		ModelAndView mView=new ModelAndView();
		List<Category> list=categoryRepository.findAll();
		mView.setViewName("c_display.jsp");
		mView.addObject("list",list);
		return mView;	
	}
	
	@RequestMapping("cinsert")
	public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		Category category=new Category();
		category.setName(req.getParameter("name"));
		Category c1= categoryRepository.save(category);
		if(c1!=null) {
			mv.setViewName("c_add.jsp");
		}
		return mv;
	}
	
	@RequestMapping("cupdate")
	public ModelAndView update(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		@SuppressWarnings("deprecation")
		Category category = categoryRepository.getById(Integer.parseInt(req.getParameter("id")));
		category.setName(req.getParameter("name"));
		Category c1=categoryRepository.save(category);
		if(c1!=null) {
			List<Category> list=categoryRepository.findAll();
			mv.setViewName("c_display.jsp");
			mv.addObject("list", list);
		}else {
			mv.setViewName("c_edit.jsp");
			mv.addObject("error","some thing is missing try again");
		}
		return mv;
	}
	@GetMapping("cdelete")
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();

		categoryRepository.deleteById(Integer.parseInt(req.getParameter("id")));
		List<Category> list=categoryRepository.findAll();
		mv.setViewName("c_display.jsp");
		mv.addObject("list",list);
		return mv;
	}
}
