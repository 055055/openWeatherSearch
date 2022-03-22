package com.example.ipinfoweather.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class AopLogConfig {
    ///@Around("execution(*com.example.ipinfoweather.*(..))")
//    @Around("execution(* com.example.ipinfoweather.controller..*.*(..))")
//    @Around("execution(* com.example.demo.service.MainService.*(..))")
    /*@Around("execution(* com.example.demo.controller..*.*(..))")*/
    /*@Around("execution(* com.example.demo..*.*(..))")*/
    @Around("execution(* com.example.ipinfoweather.interceptor..*.*(..))")
    public Object controllerLogging(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("############  REQUEST - {}({})={}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("############  RESPONSE - {}({})={}({}ms) ", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), result, end - start);
        return result;
    }

    @Around("execution(* com.example.ipinfoweather.service..*.*(..))")
    public Object serviceLogging(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("############  REQUEST SERVICE - {}({})={}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), Arrays.toString(pjp.getArgs()));
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("############  RESPONSE SERVICE- {}({})={}({}ms) ", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), result, end - start);
        return result;
    }
}
