package com.bside.BSIDE14_3.user.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bside.BSIDE14_3.user.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserDeleteController {
	private final UserService userService;

    @ApiOperation(value = "회원 탈퇴", notes = "회원 ID를 이용하여 회원을 삭제합니다.")
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) throws Exception {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
