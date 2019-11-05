package com.innovect.currencyconverter.CurrencyConverter.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@AfterReturning(value = "execution(* com.innovect.currencyconverter.CurrencyConverter.*.*.*(..))",
	        returning = "result")
	    public void afterReturning(JoinPoint joinPoint, Object result) {
	        logger.info("{} returned with value {}", joinPoint, result);
	    }
	
	 @Before("execution(* com.innovect.currencyconverter.CurrencyConverter.*.*.*(..))")
	    public void before(JoinPoint joinPoint) {
	        //Advice
	        logger.info(" Enter into methode "+joinPoint.getSignature());
	    }
}

