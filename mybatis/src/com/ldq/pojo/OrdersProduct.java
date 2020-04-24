package com.ldq.pojo;

public class OrdersProduct {

	private Integer id;
	private Integer number;
	private Orders order;
	private Product product;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrdersProduct [id=" + id + ", number=" + number + ", product=" + product + "]";
	}
}
