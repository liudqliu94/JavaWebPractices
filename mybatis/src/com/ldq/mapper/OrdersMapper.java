package com.ldq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Many;

import com.ldq.pojo.Orders;

public interface OrdersMapper {
	
	@Select("select * from orders")
	@Results(
		{
		@Result(property = "ordersProduct", column = "id", javaType = List.class,
			many = @Many(select = "com.ldq.mapper.OrdersProductMapper.getOrdersProductByOId")),
		@Result(property = "id", column = "id")
		}
	)
	public List<Orders> getAll();

}
