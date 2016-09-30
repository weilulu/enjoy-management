package com.enjoy.management.login.controller;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.management.login.service.ManageLoginService;

@RestController
@RequestMapping(value="/admin")
public class ManageLoginController {

	@Autowired
	private ManageLoginService loginService;
	
	@RequestMapping(value="toLogin")
	public String toLogin(){
		return "login";
	}
	@GET
	@RequestMapping(value="/login/{userName}/{password}")
	public String login(@PathVariable("userName")String userName,@PathVariable("password")String password){
		
		return "";
	}
}
