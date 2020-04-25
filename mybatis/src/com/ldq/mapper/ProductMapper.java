package com.ldq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.One;

import com.ldq.pojo.Category;
import com.ldq.pojo.Product;

public interface ProductMapper {

	@Select("select * from product")
	public List<Product> getAllProduct();
	
	@Update("update product set name=#{name} where id=#{id}")
	public void updateProduct(Product product);
	
	@Delete("delete from product where id=#{id}")
	public void deleteProduct(Product product);
	
	@Insert("insert into product(name) values (#{name})")
	public void insertProduct(Product product);
	
	@Select("select * from product where cid=#{id}")
	public List<Product> getProductsByCategory(Category category);
	
	@Select("select * from product where id=#{id}")
	public List<Product> getProductsById(Integer id);
	
	@Select("select * from product")
	@Results(
		{
		@Result(property = "category", column = "cid",
			one=@One(select = "com.ldq.mapper.CategoryMapper.getCategoryWithId")
		),
		@Result(property = "cid", column = "cid")
		}
	)
	public List<Product> getAll();
}
