package com.ldq.mapper;

import org.apache.ibatis.annotations.Select;

import com.ldq.pojo.User;

public interface UserMapper {
	
	@Select("select * from users where id = #{id}")
	public User selectUserById(Integer id);

}
