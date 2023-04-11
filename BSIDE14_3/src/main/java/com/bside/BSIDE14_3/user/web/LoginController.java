package com.bside.BSIDE14_3.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bside.BSIDE14_3.common.domain.AccessUser;
import com.bside.BSIDE14_3.common.domain.ResponseResult;
import com.bside.BSIDE14_3.common.domain.ResponseService;
import com.bside.BSIDE14_3.common.exception.UserException;
import com.bside.BSIDE14_3.common.util.LoginUtil;
import com.bside.BSIDE14_3.user.domain.UserDto;
import com.bside.BSIDE14_3.user.service.LoginService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author: HeeHee
 * @CreateDate: 2023. 3. 9
 *
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {

	private final LoginService loginService;
	private final ResponseService resService;

	@ApiOperation(value = "로그인", notes = "로그인을 한다.")
	@PostMapping("/login")
	public ResponseResult<Object> login(HttpServletResponse response, @RequestBody UserDto reqUser) throws UserException {
		AccessUser acUser = new AccessUser();
		try {
			acUser = loginService.login(response, reqUser);
		} catch (Exception e) {
			throw new UserException(-1, e.getMessage());
		}
		return resService.getSuccessResult(acUser);

	}

	@ApiOperation(value = "로그아웃", notes = "로그아웃을 한다.")
	@GetMapping("/logout")
	public ResponseResult<Object> logout(HttpServletRequest request, HttpServletResponse response, AccessUser acUser) {
		log.info("acUser =======> "+ acUser);
		LoginUtil.logOut(request, response);
		return resService.getSuccessResult();
	}

}
