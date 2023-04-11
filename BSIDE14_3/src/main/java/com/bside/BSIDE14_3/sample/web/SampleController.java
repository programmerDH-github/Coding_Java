package com.bside.BSIDE14_3.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bside.BSIDE14_3.common.domain.ResponseResult;
import com.bside.BSIDE14_3.common.domain.ResponseService;
import com.bside.BSIDE14_3.common.exception.UserException;
import com.bside.BSIDE14_3.sample.service.SampleService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author: HeeHee
 * @CreateDate: 2023. 3. 9
 *
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/samples")
public class SampleController {

	private final SampleService sampleService;
	private final ResponseService resService;

	@ApiOperation(value = "Sample 리스트 조회", notes = "Sample 리스트를 조회한다.")
	@GetMapping("/samples")
	public ResponseResult<Object> getSamples() {
		log.info("getSamples");

		return resService.getSuccessResult(sampleService.getSamples());
	}

	@ApiOperation(value = "Sample exception 조회", notes = "Sample exception를 조회한다.")
	@GetMapping("/exceptionSamples")
	public ResponseResult<Object> exceptionSamples() throws UserException {
		if (1 == 1) {
			throw new UserException(-1, "테스트 exception입니다.");
		}

		return resService.getSuccessResult(sampleService.getSamples());
	}

}
