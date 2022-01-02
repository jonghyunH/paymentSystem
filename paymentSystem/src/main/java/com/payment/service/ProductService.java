package com.payment.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.io.DataOutputAsStream;
import com.payment.mapper.ProductMapper;
import com.payment.mapper.UserMapper;
import com.payment.model.KakaoPayReadyDto;
import com.payment.model.ProductDto;
import com.payment.model.UserDto;

@Service
public class ProductService {
	@Autowired
	private SqlSession sqlSession;
	private static final String HOST = "https://kapi.kakao.com";
	
	public boolean productRegist(ProductDto productDto) throws Exception {
		return sqlSession.getMapper(ProductMapper.class).productRegist(productDto) == 1;
	}

	public List<ProductDto> productList() throws Exception {
		return sqlSession.getMapper(ProductMapper.class).productList();
	}

	public boolean productDelete(int product_id) {
		return sqlSession.getMapper(ProductMapper.class).productDelete(product_id);
	}

	public List<ProductDto> productSearch(String product_title) {
		return sqlSession.getMapper(ProductMapper.class).productSearch(product_title);
	}

	public String productPurchase(ProductDto productDto, UserDto userDto) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		String adminKey = "6b21dce00e489cd6688085418194a14d";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK" + adminKey);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", Integer.toString(productDto.getProduct_id()));
        params.add("partner_user_id", userDto.getEmail());
        params.add("item_name", productDto.getTitle());
        params.add("quantity", "1");
        params.add("approval_url", "https://developers.kakao.com/success");
        params.add("cancel_url", "https://developers.kakao.com/fail");
        params.add("fail_url", "https://developers.kakao.com/cancel");
		System.out.println("params" + params);
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        System.out.println("body" + body);
        // restTemplate 401 Unauthorized: [no body] 오류
        KakaoPayReadyDto kakaoPayReadyDto =
        		restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyDto.class);
        System.out.println(kakaoPayReadyDto.getNext_redirect_pc_url());
        return kakaoPayReadyDto.getNext_redirect_pc_url();
	}
	
	
}
