package com.ldq.pojo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ldq.pojo.Category;

public interface CategoryMapper {

	@Insert("INSERT INTO category (name) VALUES (#{name})")
	public int add(Category category);
	
	@Select("SELECT * FROM category")
	public List<Category> getAll();
}
