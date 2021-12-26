package com.payment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.mapper.ProductMapper;
import com.payment.mapper.UserMapper;
import com.payment.model.ProductDto;

@Service
public class ProductService {
	@Autowired
	private SqlSession sqlSession;
	
	public boolean productRegist(ProductDto productDto) throws Exception {
		return sqlSession.getMapper(ProductMapper.class).productRegist(productDto) == 1;
	}

	public List<ProductDto> productList() throws Exception {
		return sqlSession.getMapper(ProductMapper.class).productList();
	}

	public boolean productDelete(int product_id) {
		return sqlSession.getMapper(ProductMapper.class).productDelete(product_id);
	}
}
