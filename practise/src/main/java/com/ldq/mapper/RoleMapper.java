package com.ldq.mapper;

import java.util.List;

import com.ldq.pojo.Role;

public interface RoleMapper {
	
	// 新增角色
	public Integer addRole(Role role);
	
	// 删除角色
	public Integer deleteRole(Role role);
	
	// 查询所有角色
	public List<Role> getAllRoles();
	
	// 更新角色
	public Integer updateRole(Role role);

}
