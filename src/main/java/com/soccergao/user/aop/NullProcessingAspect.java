package com.soccergao.user.aop;

import com.soccergao.user.annotations.NullProcessingAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Aspect
@Component
public class NullProcessingAspect {
    @Around("com.soccergao.user.aop.SystemArchitecture.nullProcessing()  && @annotation(nullProcessingAnnotation)")
    public Object processingNull(ProceedingJoinPoint pjp, NullProcessingAnnotation nullProcessingAnnotation) throws Throwable {
        Object[] args = pjp.getArgs();
        if (args.length > 0 && Objects.isNull(args[0])) {
            if (nullProcessingAnnotation.isThrowException()) {
                throw new NullPointerException();
            }
            return null;
        }
        return pjp.proceed();
    }
}
