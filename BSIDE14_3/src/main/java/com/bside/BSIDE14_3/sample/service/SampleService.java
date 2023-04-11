package com.bside.BSIDE14_3.sample.service;

import java.util.List;
import com.bside.BSIDE14_3.sample.domain.SampleDto;

public interface SampleService {

  /**
   * 샘플 조회
   * @return 결과 데이터
   */
  
  List<SampleDto> getSamples();

}
