package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.UserDto;
import com.payment.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "회원 가입", notes = "회원 가입 진행", response = String.class)
	@PostMapping
	public ResponseEntity<String> signUp(@RequestBody @ApiParam(value = "회원가입 정보.", required = true) UserDto userDto)
			throws Exception {
		if (userService.signUp(userDto)) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="회원 정보 수정", notes="회원 정보 입력 후 수정", response=String.class)
	@PutMapping
	public ResponseEntity<String> userModify(@RequestBody UserDto userDto) throws Exception {
		userService.userModify(userDto);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
}
