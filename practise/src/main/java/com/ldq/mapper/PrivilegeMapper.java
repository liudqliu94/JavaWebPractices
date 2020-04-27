package com.ldq.mapper;

import java.util.List;

import com.ldq.pojo.Privilege;

public interface PrivilegeMapper {
	
	// 新增权限
	public Integer addPrivilege(Privilege privilege);

	// 删除权限
	public Integer deletePrivilege(Privilege privilege);
	
	// 更新权限
	public Integer updatePrivilege(Privilege privilege);
	
	// 查询所有权限
	public List<Privilege> getAllPrivilege();

}
