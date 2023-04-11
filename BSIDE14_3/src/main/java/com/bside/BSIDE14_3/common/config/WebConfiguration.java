package com.bside.BSIDE14_3.common.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bside.BSIDE14_3.common.resolver.AccessUserArgumentResolver;
import com.bside.BSIDE14_3.interceptor.AuthInterCeptor;

import lombok.RequiredArgsConstructor;

/**
* Resolver 및 InterCeptor 설정
* @author: HeeHee
* @CreateDate: 2023. 3. 13
*
*/

@RequiredArgsConstructor
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	private final AccessUserArgumentResolver accessUserArgumentResolver;

	private final AuthInterCeptor authInterCeptor;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// Token ==> AccessUser Entity
		argumentResolvers.add(accessUserArgumentResolver);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		 registry.addInterceptor(authInterCeptor)
		 .excludePathPatterns("/user/signUp")
		 .excludePathPatterns("/user/login") // 로그인
		 .excludePathPatterns("/samples/**") // 샘플
		 .excludePathPatterns("/webjars/**")
		 .excludePathPatterns("/swagger-resources/**").excludePathPatterns("/swagger-ui.html")
         .excludePathPatterns("/css/**").excludePathPatterns("/js/**")
         .excludePathPatterns("/favicon*").excludePathPatterns("/img/**");
         
	}
}
