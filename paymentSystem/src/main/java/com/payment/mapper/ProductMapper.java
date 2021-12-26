package com.payment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.payment.model.ProductDto;

@Mapper
public interface ProductMapper {
	public int productRegist(ProductDto productDto);
	public List<ProductDto> productList();
	public boolean productDelete(int product_id); 
}
