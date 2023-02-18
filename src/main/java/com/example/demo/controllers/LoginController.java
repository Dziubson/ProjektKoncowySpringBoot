package com.example.demo.controllers;


import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LoginService;

import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"username", "choose"})
public class LoginController {
	
	public static String uname;
	@Autowired
	LoginService loginService;
	

	
	@RequestMapping("/login")
	public String loginMessage(){
		return "login";
	}


	@RequestMapping("/validatelogin")
	public String dashboard(HttpServletResponse response, @RequestParam String username, @RequestParam String password,
							ModelMap model)throws MessagingException, IOException{
		model.put("username",username);
		uname=username;
		if (loginService.isValid(username,password)) {
			Cookie cookie1 = new Cookie("User", username);
			model.addAttribute("username", username);
			response.addCookie(cookie1);
			if (loginService.checkRole(username).equals("admin")){
				Cookie cookie2 = new Cookie("Role", loginService.checkRole(username));
				model.addAttribute("role", 2);
				response.addCookie(cookie2);
				return "home-admin";
			}
			else if(loginService.checkRole(username).equals("emp")){
				Cookie cookie2 = new Cookie("Role", loginService.checkRole(username));
				model.addAttribute("role", 1);
				response.addCookie(cookie2);
				return "home-empl";
			}else{
				Cookie cookie2 = new Cookie("Role", loginService.checkRole(username));
				model.addAttribute("role", 0);
				response.addCookie(cookie2);
				return "home";
			}
		}
		return "login";
	}
}
