package com.ldq;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldq.mapper.CategoryMapper;
import com.ldq.mapper.CategoryMapperUseDynaSQL;
import com.ldq.mapper.OrdersMapper;
import com.ldq.mapper.ProductMapper;
import com.ldq.pojo.Category;
import com.ldq.pojo.Orders;
import com.ldq.pojo.OrdersProduct;
import com.ldq.pojo.Product;

public class TestCURDByAnnotationWithJunit {
	
    final String resource = "mybatis-config.xml";
    SqlSession session;
    
	@Before
	public void init() throws IOException {
		System.out.println("before");
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    session = sqlSessionFactory.openSession();
	}
	
	@After
	public void close() {
		System.out.println("after");
		if (session != null) {
			session.close();
		}
	}

	@Test
	public void testSelectAll() {
		ProductMapper pMapper = session.getMapper(ProductMapper.class);
		
		//  π”√∑÷“≥
		PageHelper.offsetPage(0, 2);
		
		List<Product> results = pMapper.getAllProduct();
		
		PageInfo page = new PageInfo<>(results);
		System.out.println(page.getPages());
		
		for (Product p :  results) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testUpdate() {
		Product p = new Product();
		p.setId(1);
		p.setName("updated");
		ProductMapper pMapper = session.getMapper(ProductMapper.class);
		pMapper.updateProduct(p);
		session.commit();
		testSelectAll();
	}
	
	@Test
	public void testDelete() {
		Product p = new Product();
		p.setId(1);
		ProductMapper pMapper = session.getMapper(ProductMapper.class);
		pMapper.deleteProduct(p);
		session.commit();
		testSelectAll();
	}
	
	@Test
	public void testInsert() {
		Product p = new Product();
		p.setName("inserted");
		ProductMapper pMapper = session.getMapper(ProductMapper.class);
		pMapper.insertProduct(p);
		session.commit();
		testSelectAll();
	}
	
	@Test
	public void testGetProductsByCategory() {
		Category category = new Category();
		category.setId(1);
		ProductMapper pMapper = session.getMapper(ProductMapper.class);
		List<Product> results = pMapper.getProductsByCategory(category);
		for (Product p : results) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testOneToMany() {
		CategoryMapper cMapper = session.getMapper(CategoryMapper.class);
		List<Category> results = cMapper.getAll();
		for (Category c : results) {
			System.out.println(c);
			for (Product p : c.getProducts()) {
				System.out.println(p);
			}
		}
	}
	
	@Test
	public void testManyToOne() {
		ProductMapper pMapper = session.getMapper(ProductMapper.class);
		List<Product> results = pMapper.getAll();
		for (Product p : results) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testManyToMany() {
		OrdersMapper oMapper = session.getMapper(OrdersMapper.class);
		List<Orders> results = oMapper.getAll();
		for (Orders o : results) {
			System.out.println(o);
			for (OrdersProduct op : o.getOrdersProduct()) {
				System.out.println(op.getProduct() + ": " + op.getNumber());
			}
		}
	}
	
	@Test
	public void testGetAllCategoryUseDynamicSQL() {
		CategoryMapperUseDynaSQL cMapper = session.getMapper(CategoryMapperUseDynaSQL.class);
		List<Category> results = cMapper.getAll();
		for (Category c : results) {
			System.out.println(c);
		}
	}
}
