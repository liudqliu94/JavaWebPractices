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

import com.ldq.mapper.ProductMapper;
import com.ldq.pojo.Product;

public class TestCache {
	
    final String resource = "mybatis-config.xml";
    SqlSession session;
    SqlSessionFactory sqlSessionFactory;
    
	@Before
	public void init() throws IOException {
		System.out.println("before");
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    session = sqlSessionFactory.openSession();
	}
	
	@After
	public void close() {
		System.out.println("after");
		if (session != null) {
			session.close();
		}
	}
	
	// һ������Ĭ�Ͽ������������������ÿ�����ע�͵� mybatis �����ļ��е����ݶԱȲ��Խ��
	@Test
	public void testCache() {
		ProductMapper pMapper = session.getMapper(ProductMapper.class);
		List<Product> results = pMapper.getProductsById(1);
		System.out.println("�ڶ��β�ѯ");
		pMapper.getProductsById(1);
		System.out.println("�����β�ѯ���л�session");
		SqlSession session2 = sqlSessionFactory.openSession();
		ProductMapper pMapper2 = session2.getMapper(ProductMapper.class);
		pMapper2.getProductsById(1);
	}

}
