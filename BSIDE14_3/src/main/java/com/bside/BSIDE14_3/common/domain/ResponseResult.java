package com.bside.BSIDE14_3.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ResponseResult<T> {

  private T data;
  
  private int code;
  private String message;
  private String timestamp;
  private boolean result;

  private boolean modified = false;
}
