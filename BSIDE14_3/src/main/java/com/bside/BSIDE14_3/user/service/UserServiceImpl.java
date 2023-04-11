package com.bside.BSIDE14_3.user.service;

import com.bside.BSIDE14_3.user.persistence.UserMapper;
import com.bside.BSIDE14_3.user.domain.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    // 2023.03.23 HEEHEE 오류 수정
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Map<String, Object> duplicateCheck(String eml) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        // 이메일 중복체크
        int duplicateCheck = userMapper.duplicateCheck(eml);
        if (duplicateCheck == 0) { // 중복x
            result.put("resultCode", "00");
            result.put("resultEml", eml);
            result.put("resultMsg", "사용하실 수 있는 아이디입니다.");
        } else { // 중복o
            result.put("resultCode", "99");
            result.put("resultEml", eml);
            result.put("resultMsg", "이미 존재하는 아이디입니다.");
        }
        return result;
    }

    @Override
    public void insertUser(UserDto userDto) {
        /*
        Todo:
         이메일 유효검사
         추후 sns 로그인 추가 필요
         */
        // password 암호화
        String password = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(password);
        // 회원가입
        userMapper.insertUser(userDto);

    }
    
    
    public void deleteUser(String userId) {
        userMapper.deleteUser(userId);
    }
    
}
