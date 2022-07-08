package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogConteroller {
	
	@Autowired
	private BlogService blogService;
	
	public int title(BlogVo blogVo) {
		
		return blogService.title(blogVo);
	}
	

}
