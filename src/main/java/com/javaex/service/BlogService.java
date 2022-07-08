package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	public BlogVo title(String id) {
		System.out.println("BlogService>title-->  "+id);
		
		return blogDao.title(id);
		
	}
	
	public BlogVo blogIdCheck(String id) {
		System.out.println("BlogService>blogIdCheck-->  "+id);
		
		return blogDao.blogIdCheck(id);
	}
	
}
