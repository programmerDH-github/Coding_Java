package com.bside.BSIDE14_3.user.service;

import com.bside.BSIDE14_3.user.domain.UserDto;

import java.util.Map;

public interface UserService {

  // 회원가입
  Map<String, Object> duplicateCheck(String eml) throws Exception;
  void insertUser(UserDto userDto) throws Exception;
  
  //회원탈퇴
  void deleteUser(String userId) throws Exception;
}
