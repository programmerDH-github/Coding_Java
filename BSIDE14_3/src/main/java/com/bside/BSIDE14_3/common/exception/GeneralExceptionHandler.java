package com.bside.BSIDE14_3.common.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bside.BSIDE14_3.common.domain.ResponseResult;
import com.bside.BSIDE14_3.common.domain.ResponseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* Exception 핸들러 설정
* @author: HeeHee
* @CreateDate: 2023. 3. 22
*
*/

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
@RestControllerAdvice(annotations = RestController.class)
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

	private final ResponseService resService;

	@ExceptionHandler(UserException.class)
	public ResponseResult<Object> handleUserException(UserException ex, WebRequest request) {
		log.info("CustomGlobalExceptionHandler.handleUserException(" + ex.getCode() + ", " + ex.getMessage() + ")");
		return resService.getFailResult(ex.getCode(), ex.getMessage());
	}

}
