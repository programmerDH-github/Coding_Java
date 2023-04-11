package com.bside.BSIDE14_3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bside.BSIDE14_3.common.domain.AccessUser;
import com.bside.BSIDE14_3.common.domain.StatusCode;
import com.bside.BSIDE14_3.common.exception.UserException;
import com.bside.BSIDE14_3.common.util.LoginUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* 사용자 정보 Interceptor
* @author: HeeHee
* @CreateDate: 2023. 3. 22
*
*/

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class AuthInterCeptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("-----------> " + "inter   " + request.getRequestURL());
		
		AccessUser userDetails = LoginUtil.getAccessUserFromCookie(request);
		
		// 회원 정보가 없으면 Exception
		if (userDetails == null || userDetails.getEml() == null) {
	      throw new UserException(StatusCode.UNAUTHORIZED, "회원 정보가 없습니다.");
	    }
		
	    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	            new UsernamePasswordAuthenticationToken(userDetails, null);
	        usernamePasswordAuthenticationToken
	            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

	        // After setting the Authentication in the context, we specify
	        // that the current user is authenticated. So it passes the
	        // Spring Security Configurations successfully.
	        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		response.setHeader("Strict-Transport-Security", "max-age=31536000 ; includeSubDomains");
		response.setHeader("X-Content-Type-Options", "nosniff");
		response.setHeader("X-XSS-Protection", "1; mode=block");
	}
}
