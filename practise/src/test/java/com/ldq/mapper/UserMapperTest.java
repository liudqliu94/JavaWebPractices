package com.ldq.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {
	UserMapper uMapper;
	
	@Before
	public void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
		uMapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
	}

	@Test
	public void selectUserById() {
		System.out.println(uMapper.selectUserById(1));
	}

}
