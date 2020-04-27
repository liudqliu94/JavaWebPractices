package com.ldq.pojo;

import java.util.LinkedList;
import java.util.List;

/**
 * 角色权限定义
 */
public class Privilege {

	private Integer id;
	private String name;
	private String url;
	private Integer pid;
	private Integer isParent;
	private List<Privilege> chilldPrivilege = new LinkedList<>();

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public List<Privilege> getChilldPrivilege() {
		return chilldPrivilege;
	}
	public void setChilldPrivilege(List<Privilege> chilldPrivilege) {
		this.chilldPrivilege = chilldPrivilege;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIsParent() {
		return isParent;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", name=" + name + ", url=" + url + ", pid=" + pid + ", isParent=" + isParent
				+ ", chilldPrivilege=" + chilldPrivilege + "]";
	}
}
