package com.bside.BSIDE14_3.user.persistence;

import org.apache.ibatis.annotations.Mapper;

import com.bside.BSIDE14_3.user.domain.UserDto;

@Mapper
public interface LoginMapper {

	/**
	 * 로그인
	 * @param reqUser
	 * @return
	 */
	UserDto getLoginUserCheck(UserDto reqUser);

}
