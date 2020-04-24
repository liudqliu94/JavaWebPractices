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
 
public class TestMybatis {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
	        List<Category> cs = session.selectList("listCategory");
	        for(Category c : cs) {
	            System.out.println(c);
	        }

        	List<Product> result  = session.selectList("selectAll");
        	for (Product p : result) {
        		System.out.println(p);
        	}
        	
        	
        	// Ä£ºý²éÑ¯
        	List<Category> cFuzzy = session.selectList("selectCategoryByNameFuzzy", "up");
        	for (Category c : cFuzzy) {
        		System.out.println(c);
        	}
        }
         
    }
}