package com.enjoy.management.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoy.management.login.dao.ManageLoginMapper;

@Service
public class ManageLoginService {

	@Autowired
	private ManageLoginMapper loginMapper;
	
	/*public ManagerAdmin selectAdmin(String userName,String password){
		return loginMapper.selectAdmin(userName, password);
	}*/
}
