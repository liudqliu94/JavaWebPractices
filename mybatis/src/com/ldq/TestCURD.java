package com.ldq;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ldq.pojo.Category;

public class TestCURD {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
	        List<Category> cs = session.selectList("listCategory");
	        for(Category c : cs) {
	            System.out.println(c.getName());
	        }
        	
        	// listCategory
        	System.out.println("test query all");
        	List<Category> results = session.selectList("listCategory");
        	for (Category c : results) {
        		System.out.println(c);
        	}
        	
        	// insertCategoryByName
        	System.out.println("test insert");
        	Category cInsert = new Category();
        	cInsert.setName("insert1");
        	System.out.println(session.insert("insertCategoryByName", cInsert));
        	session.commit();
        	
        	// deleteCategoryById
        	System.out.println("test delete");
        	Category cDelete = new Category();
        	cDelete.setId(1);
        	session.delete("deleteCategoryById", cDelete);
        	
        	// selectCategoryById
        	System.out.println("test query by id");
        	Category result = session.selectOne("selectCategoryById", 1);
        	System.out.println(result);
        	
        	// updateCategoryById
        	System.out.println("test update");
        	Category cUpdate = new Category();
        	cUpdate.setId(2);
        	cUpdate.setName("updated");
        	session.update("updateCategoryById", cUpdate);
        	
        	session.commit();
        	
        	
        	System.out.println("test query all");
        	List<Category> results2 = session.selectList("listCategory");
        	for (Category c : results2) {
        		System.out.println(c);
        	}
        }
         
    }
}
