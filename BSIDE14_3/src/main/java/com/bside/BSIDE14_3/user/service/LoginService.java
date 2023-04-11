package com.bside.BSIDE14_3.user.service;

import javax.servlet.http.HttpServletResponse;

import com.bside.BSIDE14_3.common.domain.AccessUser;
import com.bside.BSIDE14_3.user.domain.UserDto;

public interface LoginService {

	/**
	 * 로그인
	 * @param response
	 * @param reqUser
	 * @return
	 * @throws Exception
	 */

	AccessUser login(HttpServletResponse response, UserDto reqUser) throws Exception;

}
