package com.ldq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ldq.pojo.Category;
import com.ldq.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("getAllCategory")
	public ModelAndView getAllCategory() {
		ModelAndView mv = new ModelAndView();
		List<Category> cs = categoryService.getAllCategory();
		
		mv.addObject("cs", cs);
		mv.setViewName("listCategory");

		return mv;
	}
}
