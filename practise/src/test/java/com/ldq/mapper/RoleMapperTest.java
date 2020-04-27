package com.ldq.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ldq.pojo.Role;

public class RoleMapperTest {
	RoleMapper rMapper;
	
	@Before
	public void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		rMapper = context.getBean("roleMapper", RoleMapper.class);
	}
	
	@Test
	public void addRole() {
		Role role = new Role();
		role.setUuid(500);
		role.setName("新增角色");
		rMapper.addRole(role);
		
	}

	@Test
	public void deleteRole() {
		Role role = new Role();
		role.setId(5);
		rMapper.deleteRole(role);
	}
	
	@Test
	public void getAllRoles() {
		List<Role> roles = rMapper.getAllRoles();
		for (Role r : roles) {
			System.out.println(r);
		}
	}
	
	@Test
	public void updateRole() {
		Role role = new Role();
		role.setId(5);
		role.setUuid(600);
		role.setName("新增被更新");
		rMapper.updateRole(role);
	}
}
