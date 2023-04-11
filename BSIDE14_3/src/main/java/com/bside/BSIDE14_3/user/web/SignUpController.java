package com.bside.BSIDE14_3.user.web;

import com.bside.BSIDE14_3.user.domain.UserDto;
import com.bside.BSIDE14_3.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * SignUpController
 *
 * @author Kang juhee
 * @version 1.0.0
 * 작성일: 2023-03-16
 **/

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class SignUpController {
    private final UserService userService;

    /**
     * 회원가입, 아이디 중복 체크
     * @param userDto
     * @return ResponseEntity
     * @throws Exception
     */
    @ApiOperation(value = "회원가입", notes = "Model: UserDto")
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto) throws Exception {
        log.info("*********sign up.************");
        log.debug(String.valueOf(userDto));
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> dupli = userService.duplicateCheck(userDto.getEml());
        if (dupli.get("resultCode") == "00") {
            // 아이디 사용 가능
            log.info((String) dupli.get("resultMsg"));
            userService.insertUser(userDto);
            result.put("resultMsg", "회원가입이 완료되었습니다.");
            return new ResponseEntity<>(dupli, HttpStatus.OK);
        } else {
            // 아이디 중복
            log.info((String) dupli.get("resultMsg"));
            return new ResponseEntity<>(dupli, HttpStatus.CONFLICT);
        }

    }

}
