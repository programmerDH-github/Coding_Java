package com.bside.BSIDE14_3.common.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.bside.BSIDE14_3.common.constants.FwConstants;
import com.bside.BSIDE14_3.common.domain.AccessUser;
import org.apache.commons.lang3.exception.ExceptionUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
*
* @author: HeeHee
* @CreateDate: 2023. 3. 22
*
*/
@Component
@Slf4j
public class TokenUtil {
	private TokenUtil() {
	}

	// 쿠키 설정
	public static final int EXPIRY = 60 * 60 * 24 * 7; // -> 60 * 60 * 24 * 7 = 7 day
	public static final boolean HTTP_ONLY = true;
	public static final boolean SECURE = false;
	public static final String SAME_SITE = "Lax";
	public static final String PATH = "/";

	// JWT_TOKEN_VALIDITY:mili seconds
	// 토큰 유효시간
	public static final long JWT_TOKEN_VALIDITY = 60L * 60L * 24L * 1L; // -> 1 day

	public static String generateJwtToken(AccessUser userInfo) {
		long dd = System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000;
		Date validity = new Date(dd);

		Map<String, Object> claims = new HashMap<>();
		claims.put(FwConstants.AccessUser.USR_NM, userInfo.getUsrNm());
		claims.put(FwConstants.AccessUser.USER_INFO, userInfo);

		JwtBuilder builder = Jwts.builder().setSubject(userInfo.getEml()).setClaims(claims).setExpiration(validity)
				.signWith(SignatureAlgorithm.HS256, FwConstants.KEY_LOGIN);

		return builder.compact();
	}

	private static Claims getClaimsFormToken(String token) throws AuthenticationException {
		return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(FwConstants.KEY_LOGIN))
				.parseClaimsJws(token).getBody();
	}

	/**
	 * 토큰 유효성 검사
	 * @param token 토큰
	 * @return 유효하면 true, 유효하지 않으면 false
	 */ 
	public static boolean isValidToken(String token) {
		try {
			Claims claims = getClaimsFormToken(token);

			log.info("expireTime :" + claims.getExpiration());
			log.info("name :" + claims.get("name"));
			log.info("Id :" + claims.get("id"));
			return true;

		} catch (ExpiredJwtException exception) {
			log.error("Token Expired");
			return false;
		} catch (JwtException exception) {
			log.error("Token Tampered");
			return false;
		} catch (NullPointerException exception) {
			log.error("Token is null");
			return false;
		}
	}

	/**
	 * 토큰으로 AccessUser 정보 생성
	 * @param token 토큰
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static AccessUser createUserInfoFromToken(String token) {
		AccessUser result = null;

		if (token == null) {
			return null;
		}
		try {
			result = new AccessUser();
			Claims claims = getClaimsFormToken(token);
			Map<String, Object> userInfo = (Map<String, Object>) claims.get(FwConstants.AccessUser.USER_INFO);

			result.setUsrNo((String) userInfo.get(FwConstants.AccessUser.USR_NO));
			result.setEml((String) userInfo.get(FwConstants.AccessUser.EML));
			result.setUsrNm((String) userInfo.get(FwConstants.AccessUser.USR_NM));
			result.setGndrClsCd((String) userInfo.get(FwConstants.AccessUser.GEDR_CLS_CD));
			result.setBrdt((String) userInfo.get(FwConstants.AccessUser.BRDT));
			result.setJoinDtm((String) userInfo.get(FwConstants.AccessUser.JOIN_DTM));
			result.setLastLgnDtm((String) userInfo.get(FwConstants.AccessUser.LAST_LGN_DTM));

		} catch (RuntimeException e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return null;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			return null;
		}
		return result;
	}

}
