package com.ldq.mapper;

import org.apache.ibatis.jdbc.SQL;

public class CategoryDynamicSQLProvider {

	public String getAll() {
		return new SQL()
				.SELECT("*")
				.FROM("category")
				.toString();
	}
	
	public String getById() {
		return new SQL()
				.SELECT("*")
				.FROM("category")
				.WHERE("id = #{id}")
				.toString();
	}
	
	public String add() {
		return new SQL()
				.INSERT_INTO("category")
				.VALUES("name", "#{name}")
				.toString();
	}
	
	public String update() {
		return new SQL()
				.UPDATE("category")
				.SET("name = #{name}")
				.WHERE("id = #{id}")
				.toString();
	}
	
	public String delete() {
		return new SQL()
				.DELETE_FROM("category")
				.WHERE("id = #{id}")
				.toString();
	}
}
