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
		System.out.println("UserController>loginForm");
		
		return "user/loginForm";
	}

	@RequestMapping(value="/user/joinForm",  method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController>joinForm");
		
		return "user/joinForm";
	}
	
	
	@RequestMapping(value="/user/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		
		System.out.println("UserController>join");
		System.out.println("UserController>join-->  "+userVo);
		
		userService.join(userVo);
	
		return "user/joinSuccess";
	}
	
	@RequestMapping(value="user/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession httpSession) {
		
		System.out.println("UserController>login");
		System.out.println(userVo);
		
		UserVo authUser = userService.login(userVo);
		
		System.out.println("UserController>login-->   "+authUser);
		
		if (authUser != null) {
			httpSession.setAttribute("authUser", authUser);
			return "redirect:/main";
		} else {
			return "redirect:loginForm?result=fail";
		}
		
		
	}
	
	@RequestMapping(value="user/logout", method= {RequestMethod.GET, RequestMethod.POST})	
	public String logout(HttpSession httpSession) {
		
		httpSession.removeAttribute("authUser");
		
		return "main/index";
	}
	
	
	
}
