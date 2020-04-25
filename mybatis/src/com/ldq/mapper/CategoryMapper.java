package com.ldq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ldq.pojo.Category;

public interface CategoryMapper {

	@Select("select * from category")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "products", javaType = List.class, column = "id",
			many = @Many(select = "com.ldq.mapper.ProductMapper.getProductsByCategory")
		)
	})
	public List<Category> getAll();
	
	@Select("select * from category where id=#{id}")
	public List<Category> getCategoryWithId(Integer id);
}
