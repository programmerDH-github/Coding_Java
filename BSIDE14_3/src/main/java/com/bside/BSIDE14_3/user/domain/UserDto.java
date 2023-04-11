package com.bside.BSIDE14_3.user.domain;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserDto implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "사용자번호", required = true)
  private String usrNo;

  @ApiModelProperty(value = "이메일", required = true)
  private String eml;

  @ApiModelProperty(value = "닉네임", required = true)
  private String usrNm;

  @ApiModelProperty(value = "비밀번호", required = true)
  private String password;

  @ApiModelProperty(value = "SNS 타입")
  private String snsClsCd;

  @ApiModelProperty(value = "SNS 토큰")
  private String snsToken;

  @ApiModelProperty(value = "성별구분", required = true)
  private String gndrClsCd;

  @ApiModelProperty(value = "생년월일", required = true)
  private String brdt;

  @ApiModelProperty(value = "계정 생성일자", required = true)
  private String joinDtm;

  @ApiModelProperty(value = "최종 로그인 일자")
  private String lastLgnDtm;

  @ApiModelProperty(value = "계정 수정일자")
  private String updateDtm;

  @ApiModelProperty(value = "탈퇴일자")
  private String whdwlDtm;

}
