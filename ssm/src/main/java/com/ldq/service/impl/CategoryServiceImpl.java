package com.ldq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldq.pojo.Category;
import com.ldq.pojo.mapper.CategoryMapper;
import com.ldq.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryMapper categoryMapper;

	public List<Category> getAllCategory() {
		return categoryMapper.getAll();
	}
}
