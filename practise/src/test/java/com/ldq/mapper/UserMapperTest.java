package com.ldq.mapper;

import java.util.Date;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ldq.pojo.User;

public class UserMapperTest {
	UserMapper uMapper;
	
	@Before
	public void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		uMapper = context.getBean("userMapper", UserMapper.class);
	}

	@Test
	public void selectUserById() {
		System.out.println(uMapper.selectUserById(1));
	}
	
	@Test
	public void selectAllUsers() {
		for (User u : uMapper.selectAllUsers()) {
			System.out.println(u);
		}
	}
	
	@Test
	public void deleteUser() {
		uMapper.deleteUser(6);
	}
	
	@Test
	public void addUser() {
		User u = new User();
		u.setName("新增的员工");
		u.setPassword("12345");
		uMapper.addUser(u);
	}
	
	@Test
	public void updateUser() {
		User u = new User();
		u.setDescription("我是新增的");
		u.setId(7);
		uMapper.updateUser(u);
	}
}
