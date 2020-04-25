package com.ldq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.ldq.pojo.Category;

public interface CategoryMapperUseDynaSQL {
	
	@SelectProvider(type = CategoryDynamicSQLProvider.class, method = "getAll")
	public List<Category> getAll();

}
