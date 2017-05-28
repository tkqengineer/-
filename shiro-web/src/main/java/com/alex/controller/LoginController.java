package com.alex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alex on 2017/5/27.
 */
@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		
		String failure = (String) request.getAttribute("shiroLoginFailure");
		
		System.out.println(failure+"ddddddddddddddddddd");
		return "login";
	}
	
}
