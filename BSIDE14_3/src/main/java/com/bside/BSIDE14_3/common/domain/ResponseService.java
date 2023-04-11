package com.bside.BSIDE14_3.common.domain;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResponseService {

	/**
	 * 정상결과(데이터)
	 * 
	 * @param response 처리결과
	 * @return ResponseResult<T>
	 */
	public <T> ResponseResult<T> getSuccessResult(T response) {
		ResponseResult<T> result = new ResponseResult<>();
		result.setData(response);
		setSuccessResult(result);
		return result;
	}

	/**
	 * 정상 결과(일반)
	 * 
	 * @return ResponseResult<Object>
	 */
	public ResponseResult<Object> getSuccessResult() {
		ResponseResult<Object> result = new ResponseResult<>();
		setSuccessResult(result);
		return result;
	}

	/**
	 * 정상결과(그리드)
	 * 
	 * @param modified Grid인 경우 C/U/D의 경우 정상처리 여부 설정.
	 * @return ResponnseResult<Object>
	 */
	public ResponseResult<Object> getSuccessResult(boolean modified) {
		ResponseResult<Object> result = new ResponseResult<>();
		setSuccessResult(result);
		/* Grid인 경우 C/U/D의 경우 정상처리 여부 설정. */
		result.setModified(modified);
		return result;
	}

	/**
	 * 에러처리
	 * 
	 * @param code 에러코
	 * @param msg  에러 메시
	 * @return ResponseResult<Object>
	 */
	public ResponseResult<Object> getFailResult(int code, String msg) {
		String ts = getCurrentSystemStampWithZone();
		ResponseResult<Object> result = new ResponseResult<>();
		result.setCode(code);
		result.setMessage(msg);
		result.setTimestamp(ts);
		/* Grid인 경우 C/U/D의 경우 오류 여부 설정. */
		result.setModified(false);
		return result;
	}

	/**
	 * 그리드의 modified 필드 추가.
	 * 
	 * @param code     에러코
	 * @param msg      에러 메시
	 * @param modified Grid인 경우 C/U/D의 경우 오류 여부 설정.
	 * @return ResponseResult<Object>
	 */
	public ResponseResult<Object> getFailResult(int code, String msg, boolean modified) {
		String ts = getCurrentSystemStampWithZone();
		ResponseResult<Object> result = new ResponseResult<>();
		result.setCode(code);
		result.setMessage(msg);
		result.setTimestamp(ts);
		/* Grid인 경우 C/U/D의 경우 오류 여부 설정. */
		result.setModified(modified);
		return result;
	}

	public String getCurrentSystemStampWithZone() {
		Date currentUtcTime = Date.from(Instant.now());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		return sdf.format(currentUtcTime);
	}

	private void setSuccessResult(ResponseResult result) {
		String ts = getCurrentSystemStampWithZone();
		result.setCode(StatusCode.OK);
		result.setMessage("Success");
		result.setResult(true);
		result.setTimestamp(ts);
	}

}
