package com.payment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.UserDto;
import com.payment.service.JwtService;
import com.payment.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
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
	
	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지 반환", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String,Object>> login(@RequestBody @ApiParam(value = "아이디, 비밀번호", required = true) UserDto userDto){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			UserDto loginUser = userService.login(userDto);
			if(loginUser != null) {
				String token = jwtService.create("loginUser", loginUser, "access-token");
				resultMap.put("access-token", token);
				resultMap.put("message", "SUCCESS");
				return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
			}
		}catch(Exception e){
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.NO_CONTENT);
	}
}
