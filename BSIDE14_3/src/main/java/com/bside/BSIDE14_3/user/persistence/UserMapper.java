package com.bside.BSIDE14_3.user.persistence;

import com.bside.BSIDE14_3.user.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  int duplicateCheck(String eml);
  void insertUser(UserDto userDto);
  
  void deleteUser(String userId);
}
