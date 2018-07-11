package com.mercury.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/7/11-16:11
 * @Description:
 * @return:
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
   public Docket createRestApi(){
      return  new Docket(DocumentationType.SWAGGER_2)
		  .apiInfo(apiInfo())
		  .select()
		  .apis(RequestHandlerSelectors.basePackage("com.mercury.controller"))
		  .paths(PathSelectors.any())
		  .build();
   }

   private ApiInfo apiInfo() {
      return  new ApiInfoBuilder()
		  	.title("Account swagger Rest API  ")
		  	.description("springboot Accout API 文档")
		  	.termsOfServiceUrl("http://www.baidu.com")
		  	.version("v1.0.0")
		  	.build();
   }
}
