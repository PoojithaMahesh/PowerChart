package com.ty.springboot_project.dto;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	public Docket getDocket() {
		
		Contact contact=new Contact("TY", "www.testyantra.com", "tysupport@gmail.com");
		
		List<VendorExtension> extensions=new ArrayList<>();
		
		ApiInfo info= new ApiInfo("Hospital Project", "Hospital api v1.0", "verion 1.0", "www.ty.global.com", contact, "adtdgh127212", "www.ty.com", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ty.springboot_hospitalproject")).build().apiInfo(info).useDefaultResponseMessages(false);
		
	}
}

