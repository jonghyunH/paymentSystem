package com.payment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:8080/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Payment System API")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.payment.controller"))
				.paths(postPaths())
				.build();
	}
	
	private Predicate<String> postPaths() {
		return PathSelectors.any();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Payment System")
				.description("Jonghyun for Developers")
				.license("Jonghyun License")
				.licenseUrl("Jonghyun").version("1.0").build();
	}
}
