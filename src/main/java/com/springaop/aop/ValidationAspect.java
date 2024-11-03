package com.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);
	
	@Around("execution(* com.springaop.services.JobService.viewJob(..)) && args(id)")
//  Always ProceedingJoinPoint Comes first and then parameters in args
	public Object validateAndUpdate(ProceedingJoinPoint jp,int id) throws Throwable
	{
		if(id < 0)
		{
			LOGGER.info("id is negative");
			id = -id;
			LOGGER.info("changed id to: "+id);
		}
		
		Object obj = jp.proceed(new Object[] {id});
		
		return obj;
	}

}

//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;

//@Component
//@Aspect
//public class ValidationAspect {
//
//	
//	public static final Logger LOGGER=LoggerFactory.getLogger(ValidationAspect.class);
//	
//	
//	@Around("execution (* com.springaop.services.JobService.viewJob(..)) && args(id)")
//	public Object validateAndUpdate(ProceedingJoinPoint jp,int id) throws Throwable {
//	if (id<0) {
//		LOGGER.info("PostId is negative, updating it");
//		
//		id=-id;
//		LOGGER.info("new Value "+id);
//	}
//	
//	Object obj=jp.proceed(new Object[] {id});
//		
//		
//		
//		return obj;
//	}
//}
