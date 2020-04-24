package com.ldq.pojo;

import java.util.List;

// һ�� category ��Ӧ��� product
public class Category {
    private Integer id;
    private String name;
    private List<Product> products;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}  
}