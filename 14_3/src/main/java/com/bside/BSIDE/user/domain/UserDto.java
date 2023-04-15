package com.bside.BSIDE.user.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	@Schema(description = "사용자 ID", example = "2")
    private int id;
	
	@Schema(description = "사용자 이름", example = "Lee")
    private String username;
	
	@Schema(description = "사용자 비밀번호", example = "1234")
    private String password;
    
	@Schema(description = "사용자 이메일", example = "test@naver.com")
    private String email;
}
