package com.bside.BSIDE14_3.common.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.multipart.MultipartFile;

import com.bside.BSIDE14_3.common.domain.AccessUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* 컨트롤러 호출 시 로그 생성
* @author: HeeHee
* @CreateDate: 2023. 3. 13
*
*/

@Slf4j
@Aspect
@RequiredArgsConstructor
@Component
public class LogAspect {

	private final HttpServletRequest request;

	@Around("execution(* com.bside.BSIDE14_3..web.*Controller.*(..))")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "." + methodName;

		String strRequest = "";
		ObjectMapper mapper = new ObjectMapper();
		StopWatch sw = new StopWatch();
		sw.start();

		boolean isServletRequest = isHttpServletRequest(request);

		if (isServletRequest) {
			List<Object> lstArgs = new ArrayList<>();
			Object[] methodArguments = pjp.getArgs();
			for (Object obj : methodArguments) {
				if (obj instanceof MultipartFile || obj instanceof HttpServletRequest
						|| obj instanceof HttpServletResponse || obj instanceof AccessUser) {
					continue;
				}
				lstArgs.add(obj);
			}
			strRequest = mapper.writeValueAsString(lstArgs);
		}

		result = pjp.proceed();
		// after advice
		sw.stop();
		Long total = sw.getTotalTimeMillis();

		log.info("[ExecutionTime] " + taskName + " , " + total + "(ms)");
	    return result;
	}
	
	private boolean isHttpServletRequest(HttpServletRequest request) {
	    try {
	      request.getCookies();
	    } catch(Exception e)
	    {
	      return false;
	    }
	    return true;
	  }
}
