package com.enjoy.management.login.dao;

import org.springframework.stereotype.Repository;


@Repository
public interface ManageLoginMapper {

	/*@Select(value = { "SELECT * FROM sys_user where user_name=#{userName} and password=#{password} limit 1" })
	public ManagerAdmin selectAdmin(String userName,String password);*/
}
