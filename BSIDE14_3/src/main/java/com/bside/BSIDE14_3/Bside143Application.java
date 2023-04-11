package com.bside.BSIDE14_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.bside.BSIDE14_3")
@ServletComponentScan("com.bside.BSIDE14_3")
@SpringBootApplication
public class Bside143Application extends SpringBootServletInitializer {
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Bside143Application.class);
  }
  
    
  public static void main(String[] args) {
    SpringApplication.run(Bside143Application.class, args);
    System.out.println("hello");
  }
}
