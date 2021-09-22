package com.soccergao.user.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {
    @Pointcut("@annotation(com.soccergao.user.annotations.NullProcessingAnnotation)")
    public void nullProcessing() {
    }

    @Pointcut("execution(* com.soccergao.user.service.*.*(..))")
    public void logOperation() {
    }
}
