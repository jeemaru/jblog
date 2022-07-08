package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogConteroller {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="/{id}", method= {RequestMethod.GET, RequestMethod.POST})
	public String title(@PathVariable("id") String id, Model model ) {
		
		System.out.println("BlogConteroller>title-->" +id);
		BlogVo bVo = blogService.title(id);
		System.out.println("BlogConteroller>title--> bVo-->"+bVo);
		
		model.addAttribute("bVo", bVo);
		
		
		return "blog/blog-main";
	}
	
	@RequestMapping(value="/{id}check", method= {RequestMethod.GET, RequestMethod.POST})
	public String blogIdCheck(@PathVariable("id") String id, Model model) {
		
		System.out.println("BlogConteroller>blogIdCheck-->" +id);
		BlogVo cVo = blogService.blogIdCheck(id);
		System.out.println("BlogConteroller>blogIdCheck--> bVo-->"+cVo);
		
		model.addAttribute("cVo", cVo);
		
		return "";
	}
	

}
