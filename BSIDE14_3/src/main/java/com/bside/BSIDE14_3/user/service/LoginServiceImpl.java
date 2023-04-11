package com.bside.BSIDE14_3.user.service;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bside.BSIDE14_3.common.domain.AccessUser;
import com.bside.BSIDE14_3.common.exception.UserException;
import com.bside.BSIDE14_3.common.util.LoginUtil;
import com.bside.BSIDE14_3.user.domain.UserDto;
import com.bside.BSIDE14_3.user.persistence.LoginMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
	
	 private final LoginMapper loginMapper;
	 
	 private PasswordEncoder encoder = new BCryptPasswordEncoder();
	 
	 /**
	 * 로그인
	 * @param response
	 * @param reqUser
	 * @return
	 * @throws UserException 
	 * @throws Exception
	 */
	@Override
	public AccessUser login(HttpServletResponse response, UserDto reqUser) throws UserException {
		UserDto dbUser = new UserDto();
		
		if(!StringUtils.isEmpty(reqUser.getEml())) {
			dbUser = loginMapper.getLoginUserCheck(reqUser);
		}
		
		// DB 데이터가 없을 경우
		if (dbUser == null) {
			throw new UserException(-1, "일치하는 정보가 없습니다.");
		}
		
		String whdwlDtm = dbUser.getWhdwlDtm();
		String dbPw = dbUser.getPassword();
		String parameterPw = reqUser.getPassword();
		
		
		// 탈퇴한 회원
		if (!StringUtils.isEmpty(whdwlDtm)) {
			throw new UserException(-1, "탈퇴한 회원입니다.");
		}
		
		// 비밀번호 일치 여부 판단
		if (!encoder.matches(parameterPw, dbPw)) {
			throw new UserException(-1, "비밀번호가 일치하지 않습니다.");
		}
		
		
		AccessUser acUser = new AccessUser();
		acUser.setUsrNo(dbUser.getUsrNo());
		acUser.setEml(dbUser.getEml());
		acUser.setUsrNm(dbUser.getUsrNm());
		acUser.setGndrClsCd(dbUser.getGndrClsCd());
		acUser.setBrdt(dbUser.getBrdt());
		acUser.setJoinDtm(dbUser.getJoinDtm());
		acUser.setLastLgnDtm(dbUser.getLastLgnDtm());
		
		String accessToken = LoginUtil.generateLoginCookie(response, acUser);
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(acUser, dbPw);
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		
		return acUser;
	}

}
