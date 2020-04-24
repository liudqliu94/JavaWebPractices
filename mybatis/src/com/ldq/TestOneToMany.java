package com.ldq;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ldq.pojo.Category;
import com.ldq.pojo.Product;

public class TestOneToMany {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
        	List<Category> results = session.selectList("selectCategoryAndProducts");
        	for (Category c : results) {
        		System.out.println(c);
        		for (Product p : c.getProducts()) {
        			System.out.println(p);
        		}
        	}
        }
         
    }
}
