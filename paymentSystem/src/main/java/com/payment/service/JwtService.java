package com.payment.service;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import com.payment.model.UserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import springfox.documentation.spring.web.json.Json;

@Service
public class JwtService {
	private String secretKey = "secret";
	
	@Autowired
	UserService userService;
	
	
	public <T> String create(String key, T data, String subject) {
		String jwt = Jwts.builder().setHeaderParam("typ", "JWT").setHeaderParam("regDate", System.currentTimeMillis())
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
				.setSubject(subject).claim(key, data).signWith(SignatureAlgorithm.HS256, secretKey).compact();
		return jwt;
	}

	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = "Secret".getBytes("UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return key;
	}
    
    // 토큰에서 회원 정보 추출
    public LinkedHashMap getUserPk(String token) {
    	LinkedHashMap linkedHashMap = new LinkedHashMap();
    	linkedHashMap = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("loginUser",LinkedHashMap.class);
    	System.out.println(linkedHashMap.get("name"));
    	System.out.println(linkedHashMap.get("email"));
    	System.out.println(linkedHashMap.get("password"));
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("loginUser",LinkedHashMap.class);
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
