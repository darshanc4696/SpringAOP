package com.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
//			("execution(return_type fullyQualifiedPathName(args))")
//			("execution(return_type fullyQualifiedPathName(args)) || execution(return_type fullyQualifiedPathName(args))")
	@Before("execution(* com.springaop.services.JobService.*(..))")
	public void logscallBefore(JoinPoint jp)
	{
		LOGGER.info("Method Called " + jp.getSignature().getName());
	}
	
	@After("execution(* com.springaop.services.JobService.*(..))")
	public void logscallAfter(JoinPoint jp)
	{
		LOGGER.info("Method Execution Completed " + jp.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.springaop.services.JobService.*(..))")
	public void logsIssues()
	{
		LOGGER.info("Something issue occured");
	}
	
	@AfterReturning("execution(* com.springaop.services.JobService.*(..))")
	public void logsClear()
	{
		LOGGER.info("Method Succesfully Executed");
	}

}
