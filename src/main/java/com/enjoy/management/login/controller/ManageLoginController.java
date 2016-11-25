package com.enjoy.management.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.management.login.service.ManageLoginService;

@RestController
@RequestMapping(value="/admin")
public class ManageLoginController {

	@Autowired
	private ManageLoginService loginService;
	
	@RequestMapping(value="toLogin",method = RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	/*@GET
	@RequestMapping(value="/login/{userName}/{password}")
	public String login(@PathVariable("userName")String userName,
			            @PathVariable("password")String password,
			            Model model){
		ManagerAdmin admin = loginService.selectAdmin(userName, password);
		model.addAttribute("admin", admin);
		return "login";
	}*/
}
