package com.enjoy.management.login.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.enjoy.management.domain.ManagerAdmin;


@Repository
public interface ManageLoginMapper {

	@Select(value = { "SELECT * FROM sys_user where user_name=#{userName} and password=#{password} limit 1" })
	public ManagerAdmin selectAdmin(String userName,String password);
}
