package com.ldq.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ldq.pojo.Privilege;

public class PrivilegeMapperTest {
	PrivilegeMapper pMapper;
	
	@Before
	public void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		pMapper = context.getBean("privilegeMapper", PrivilegeMapper.class);
	}
	
	@Test
	public void addPrivilege() {
		Privilege privilege = new Privilege();
		privilege.setIsParent(1);
		privilege.setName("新增的");
		privilege.setPid(1);
		privilege.setUrl("hello");
		pMapper.addPrivilege(privilege);
	}
	
	@Test
	public void deletePrivilege() {
		Privilege privilege = new Privilege();
		privilege.setId(5);
		pMapper.deletePrivilege(privilege);
	}

	@Test
	public void updatePrivilege() {
		Privilege privilege = new Privilege();
		privilege.setId(5);
		privilege.setUrl("更新的");
		pMapper.updatePrivilege(privilege);
	}
	
	@Test
	public void getAllPrivilege() {
		List<Privilege> privileges = pMapper.getAllPrivilege();
		for (Privilege p : privileges) {
			System.out.println(p);
		}
	}
}
