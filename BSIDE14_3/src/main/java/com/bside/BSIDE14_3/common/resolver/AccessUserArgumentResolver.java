package com.bside.BSIDE14_3.common.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.bside.BSIDE14_3.common.domain.AccessUser;
import com.bside.BSIDE14_3.common.util.LoginUtil;

/**
*
* 컨트롤러에 파라미터로 사용자 정보를 매핑 시켜준다.
* @author: HeeHee
* @CreateDate: 2023. 3. 22
*
*/

@Component
public class AccessUserArgumentResolver implements HandlerMethodArgumentResolver {
	
	@Override
	public AccessUser resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

		return LoginUtil.getAccessUserFromCookie(request);
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return AccessUser.class.isAssignableFrom(parameter.getParameterType());
	}

}
