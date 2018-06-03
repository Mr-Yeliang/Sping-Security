package com.example.demo.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class welcomeController {
	/**
	 * 登录验证
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login2";
		//return "loginpage";
	}

	/**
	 * 主页跳转
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/")
	public String login1(HttpServletRequest request) {
		//获取所有Session信息
		Enumeration<String> e = request.getSession().getAttributeNames();
		//遍历Session
		while (e.hasMoreElements()) {
			String sessionName = (String) e.nextElement();
			System.out.println("sessionName：");
			System.out.println(sessionName);
			System.out.println("session：");
			System.out.println(request.getSession().getAttribute(sessionName));
			System.out.println("----------------------------------\n");

		}
		// 获得当前登陆用户对应的对象
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("userDetails：");
		System.out.println(userDetails);
		System.out.println("----------------------------------\n");

		return "index";
	}

}
