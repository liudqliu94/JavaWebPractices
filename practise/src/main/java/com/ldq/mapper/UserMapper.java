package com.ldq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldq.pojo.User;

public interface UserMapper {
	// 根据 id 查询用户
	public User selectUserById(@Param("id")Integer id);
	
	// 查询所有用户
	public List<User> selectAllUsers();
	
	// 更新一个用户信息
	public Integer updateUser(User user);
	
	// 删除一个用户
	public Integer deleteUser(Integer id);
	
	// 添加一个用户
	public Integer addUser(User user);

}
