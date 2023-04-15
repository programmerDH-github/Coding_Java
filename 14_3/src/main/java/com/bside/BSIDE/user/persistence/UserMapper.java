package com.bside.BSIDE.user.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.bside.BSIDE.user.domain.UserDto;


@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(id, username, password, email) VALUES(#{id}, #{username}, #{password}, #{email})")
    void insertUser(UserDto userDto);
    List<UserDto> getAllUsers();
}
