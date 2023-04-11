package com.bside.BSIDE14_3.sample.domain;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SampleDto implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "이름", example = "홍길동", required = true)
  private String name;

  @ApiModelProperty(value = "내용", example = "Contents", required = false)
  private String contents;


}
