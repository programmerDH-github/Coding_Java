package com.bside.BSIDE14_3.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger UI 설정
 * @author HEEHEE
 * @CreateDate: 2023. 3. 9
 *
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig{

  @Bean
  public Docket comonApi() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }
  
  
}
