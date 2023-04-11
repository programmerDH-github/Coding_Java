package com.bside.BSIDE14_3.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
* 사용자 관련 Exception 설정
* @author: HeeHee
* @CreateDate: 2023. 3. 22 
*
*/
@Getter
@Setter
public class UserException extends Exception {
  private static final long serialVersionUID = 1L;

  protected final HttpStatus status;
  protected final int code;
  protected final String message;

  /*
   * API
   */
  public UserException(HttpStatus status, int code, String message) {
    super();
    this.status = status;
    this.code = code;
    this.message = message;
  }

  /*
   * Web / App
   */
  public UserException(int code, String message) {
    super();
    this.status = HttpStatus.METHOD_NOT_ALLOWED;
    this.code = code;
    this.message = message;
  }
}
