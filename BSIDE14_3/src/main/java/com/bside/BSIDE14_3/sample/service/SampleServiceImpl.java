package com.bside.BSIDE14_3.sample.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bside.BSIDE14_3.sample.domain.SampleDto;
import com.bside.BSIDE14_3.sample.persistence.SampleMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("SampleServiceImpl")
public class SampleServiceImpl implements SampleService {

    private final SampleMapper sampleMapper;
    
    /**
     * 샘플 조회
     * @return 결과 데이터
     */
    @Override
    public List<SampleDto> getSamples() {
      return sampleMapper.getSamples();
    }
}
