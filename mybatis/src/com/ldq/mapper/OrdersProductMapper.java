package com.ldq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;

import com.ldq.pojo.OrdersProduct;

public interface OrdersProductMapper {
	
	@Select("select * from orders_product where oid = #{id}")
	@Results(
			{
				@Result(property = "product", column = "pid",
						one = @One(select = "com.ldq.mapper.ProductMapper.getProductsById")
						)
			}
	)
	public List<OrdersProduct> getOrdersProductByOId(int id);

}
