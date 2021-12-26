package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.ProductDto;
import com.payment.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "상품 등록", notes = "상품 등록", response = String.class)
	@PostMapping
	public ResponseEntity<String> productRegist(@RequestBody @ApiParam(value="상품 등록", required = true) ProductDto productDto) throws Exception{
		if(productService.productRegist(productDto)) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "상품 목록", notes = "상품 목록", response = String.class)
	@GetMapping
	public ResponseEntity<List<ProductDto>> productList() throws Exception{
		return new ResponseEntity<List<ProductDto>>(productService.productList(), HttpStatus.OK); 
	}
	
	@ApiOperation(value = "상품 삭제", notes = "상품 삭제", response = String.class)
	@DeleteMapping("/{product_id}")
	public ResponseEntity<String> productDelete(@PathVariable @ApiParam(value="상품 삭제", required = true) int product_id){
		if(productService.productDelete(product_id)) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
	}
}
