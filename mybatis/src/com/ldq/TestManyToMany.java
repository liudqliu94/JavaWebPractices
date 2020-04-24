package com.ldq;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ldq.pojo.Orders;
import com.ldq.pojo.OrdersProduct;

public class TestManyToMany {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
        	List<Orders> results = session.selectList("getAllOrders");
        	for (Orders o : results) {
        		System.out.println(o);
        		for (OrdersProduct op : o.getOrdersProduct()) {
        			System.out.println(op);
        		}
        	}
        }
         
    }
}
