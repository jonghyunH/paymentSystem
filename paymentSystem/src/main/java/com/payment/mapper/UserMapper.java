package com.payment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.payment.model.UserDto;

@Mapper
public interface UserMapper {
	public int signUp(UserDto userDto);
}
