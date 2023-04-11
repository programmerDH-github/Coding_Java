package com.bside.BSIDE14_3.sample.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bside.BSIDE14_3.sample.domain.SampleDto;

@Mapper
public interface SampleMapper {

  /**
   * 샘플 조회
   * @return 결과 데이터
   */
  List<SampleDto> getSamples();
  
}
