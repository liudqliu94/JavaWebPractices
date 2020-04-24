package com.ldq.pojo;

import java.util.List;

public class Orders {
	private Integer id;
	private String code;

	List<OrdersProduct> ordersProduct;
	
	public List<OrdersProduct> getOrdersProduct() {
		return ordersProduct;
	}
	public void setOrdersProduct(List<OrdersProduct> ordersProduct) {
		this.ordersProduct = ordersProduct;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", code=" + code + "]";
	}
}
