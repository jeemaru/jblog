package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/loginForm",  method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("MainController>loginForm");
		
		return "user/loginForm";
	}

	@RequestMapping(value="/user/joinForm",  method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("MainController>joinForm");
		
		return "user/joinForm";
	}
	
	
	@RequestMapping(value="/user/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		
		System.out.println("UserController>join");
		
		userService.join(userVo);
	
		return "user/joinSuccess";
	}
	
	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession httpSession) {
		
		System.out.println("UserController>login");
		
		UserVo authUser = userService.login(userVo);
		
		if (authUser != null) {
			httpSession.setAttribute("authUser", authUser);
			return "redirect:main";
		} else {
			return "redirect:loginForm?result=fail";
		}
		
	}
	
	@RequestMapping(value="/logout", method= {RequestMethod.GET, RequestMethod.POST})	
	public String logout(HttpSession httpSession) {
		
		httpSession.removeAttribute("authUser");
		
		return "main/index";
	}
	
}
