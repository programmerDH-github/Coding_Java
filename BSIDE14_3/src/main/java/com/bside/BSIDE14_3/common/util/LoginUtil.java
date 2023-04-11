package com.bside.BSIDE14_3.common.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import com.bside.BSIDE14_3.common.constants.FwConstants;
import com.bside.BSIDE14_3.common.domain.AccessUser;

import lombok.extern.slf4j.Slf4j;

/**
*
* @author: HeeHee
* @CreateDate: 2023. 3. 22
*
*/
@Component
@Slf4j
public class LoginUtil {
	private LoginUtil() {
	}

	/**
	 * 쿠키 생성
	 * @param response
	 * @param acuser
	 * @return
	 */
	public static String generateLoginCookie(HttpServletResponse response, AccessUser acuser) {
		String sLoginToken = TokenUtil.generateJwtToken(acuser);

		// 쿠키 정보를 특정짓기 위해 BEARER_ 추가
		ResponseCookie storeTokenCookie = ResponseCookie.from(FwConstants.GOMING_SES, FwConstants.BEARER + sLoginToken)
				.httpOnly(TokenUtil.HTTP_ONLY).path(TokenUtil.PATH).secure(TokenUtil.SECURE)
				.sameSite(TokenUtil.SAME_SITE).build();
		response.addHeader(FwConstants.SET_COOKIE, storeTokenCookie.toString());

		return sLoginToken;
	}

  /**
   * 쿠키를 가져온다 	
   * @param request
   * @return
   */
	public static List<String> getAccessCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		List<String> lstTokenHeader = new ArrayList<>();

		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				String name = StringUtils.defaultString(cookie.getName());
				if (FwConstants.GOMING_SES.equals(name)) {
					lstTokenHeader.add(StringUtils.defaultString(cookie.getValue()));
				}
			}
		}
		return lstTokenHeader;
	}

	/**
	 * 쿠키로부터 사용자 정보 생성
	 * @param request
	 * @return
	 */
	public static AccessUser getAccessUserFromCookie(HttpServletRequest request) {
		List<String> lstTokenHeader = getAccessCookie(request);

		if (lstTokenHeader.isEmpty()) {
			return new AccessUser();
		}

		log.info("-->> " + request.getRequestURI());
		String cookie = "";
		for (String requestTokenHeader : lstTokenHeader) {
			if ((requestTokenHeader != null && requestTokenHeader.startsWith(FwConstants.BEARER))) {
				cookie = requestTokenHeader;
			}
		}
		return getAccessUserFromCookie(cookie);
	}

	/**
	 * 쿠키로부터 사용자 정보를 가져온다.
	 * @param cookie
	 * @return
	 */
	public static AccessUser getAccessUserFromCookie(String cookie) {
		AccessUser result = new AccessUser();
		String jwtToken = "";
		if ((cookie != null && cookie.startsWith(FwConstants.BEARER))) {
			String tmpJwtToken = cookie.substring(7);
			if ("".equals(StringUtils.defaultString(tmpJwtToken))) {
				return result;
			}
			boolean tag = TokenUtil.isValidToken(tmpJwtToken);
			if (!tag) {
				return result;
			}
			jwtToken = tmpJwtToken;
		}
		if ("".equals(StringUtils.defaultString(jwtToken))) {
			return result;
		}

		result = TokenUtil.createUserInfoFromToken(jwtToken);
		return result;
	}

	/**
	 * 로그아웃
	 * @param request
	 * @param response
	 */
	public static void logOut(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (FwConstants.GOMING_SES.equals(cookie.getName())) {

					ResponseCookie storeTokenCookie = ResponseCookie.from(FwConstants.GOMING_SES, "")
							.httpOnly(TokenUtil.HTTP_ONLY).maxAge(0).path(TokenUtil.PATH).secure(TokenUtil.SECURE)
							.sameSite(TokenUtil.SAME_SITE).build();
					response.addHeader(FwConstants.SET_COOKIE, storeTokenCookie.toString());
				}
			}
		}
	}
}
