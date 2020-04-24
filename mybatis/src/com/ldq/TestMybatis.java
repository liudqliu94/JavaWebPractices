package com.ldq;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//	        List<Category> cs = session.selectList("listCategory");
//	        for(Category c : cs) {
//	            System.out.println(c);
//	        }

        	List<Product> result  = session.selectList("selectAll");
        	for (Product p : result) {
        		System.out.println(p);
        	}
        	
        	
        	System.out.println("tag test");
        	
//        	Map<String, Object> paramsUpdate = new HashMap<>();
//        	paramsUpdate.put("name", "xx");
//        	paramsUpdate.put("price", "800");
//        	paramsUpdate.put("id", "6");
//        	session.update("updateProductUseTrim", paramsUpdate);
        	
//        	Map<String, Object> params = new HashMap<>();
//        	params.put("name", "x");
//        	List<Product> resultFuzzy = session.selectList("selectAllWithChoose", params);
//        	for (Product p : resultFuzzy) {
//        		System.out.println(p);
//        	}
        	
//        	List<Integer> ids = new ArrayList<>();
//        	ids.add(1);
//        	ids.add(2);
//        	List<Product> prange = session.selectList("selectInRange", ids);
//        	for(Product p : prange) {
//        		System.out.println(p);
//        	}
        	
        	Map<String, Object> params = new HashMap<>();
        	params.put("name", "x");
        	List<Product> pBind = session.selectList("selectWithBind", params);
        	for (Product p : pBind) {
        		System.out.println(p);
        	}
        	
        	
//        	// Ä£ºý²éÑ¯
//        	List<Category> cFuzzy = session.selectList("selectCategoryByNameFuzzy", "up");
//        	for (Category c : cFuzzy) {
//        		System.out.println(c);
//        	}
        	session.commit();
        }
         
    }
}