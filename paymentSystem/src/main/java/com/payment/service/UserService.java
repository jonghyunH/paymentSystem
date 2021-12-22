package com.payment.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.mapper.UserMapper;
import com.payment.model.UserDto;

@Service
public class UserService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean signUp(UserDto userDto) throws Exception {
		return sqlSession.getMapper(UserMapper.class).signUp(userDto) == 1;
	}
}
