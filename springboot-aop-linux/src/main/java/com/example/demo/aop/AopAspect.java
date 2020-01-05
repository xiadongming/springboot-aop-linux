package com.example.demo.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AopAspect {
	private final Logger logger = LoggerFactory.getLogger(AopAspect.class);
	@Pointcut("execution(public * com.example.demo.web..*.*(..))")
	public void webLog() {};

	@Before(value = "webLog()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.error("目标方法执行之前，before()方法执行==="+request.getRequestURI().toString());
		logger.error("目标方法执行之前，before()方法执行==="+request.getRemoteAddr());
	}
	@AfterReturning(returning = "ret",pointcut ="webLog()")
	public void doAfterreturn(Object ret) {
		//object ret是拦截的方法，所返回的return 的值
		logger.error("目标方法执行之后，after()方法执行==="+ret.toString());
		
	}
	
	
	
}
