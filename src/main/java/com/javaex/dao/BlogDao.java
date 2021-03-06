package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public BlogVo title(String id) {
		System.out.println("BlogDao>title-->" + id);
		return sqlSession.selectOne("blog.title", id);
	}
	
	public BlogVo blogIdCheck(String id) {
		System.out.println("BlogDao>title-->  "+ id);
		return sqlSession.selectOne("blog.blogIdCheck", id);
		
	}
	
}
