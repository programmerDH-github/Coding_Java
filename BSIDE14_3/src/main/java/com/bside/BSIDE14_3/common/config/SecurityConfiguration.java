package com.bside.BSIDE14_3.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

/**
* 스프링 시큐리티 설정
* @author: HeeHee
* @CreateDate: 2023. 3. 13
*
*/

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic().disable();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/**").permitAll().and().logout().permitAll()
				.and().formLogin();
		return http.build();
	}

}
