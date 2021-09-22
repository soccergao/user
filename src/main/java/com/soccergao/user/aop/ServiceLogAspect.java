package com.soccergao.user.aop;

import com.soccergao.user.utils.JsonConverter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class ServiceLogAspect {
    private final JsonConverter jsonConverter;

    public ServiceLogAspect(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @Around("com.soccergao.user.aop.SystemArchitecture.logOperation()")
    public Object doLogOperation(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method method = pjp.getTarget().getClass().getMethod(ms.getName(), ms.getParameterTypes());
        String methodName = pjp.getTarget().getClass().getName() + "#" + method.getName();
        log.info("方法{}参数： {}", method.getName(), methodName, jsonConverter.writeValueAsString(pjp.getArgs()));
        stopWatch.start();
        Object retVal = pjp.proceed();
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        log.info("方法{}耗时: {}, 返回结果: {}", method.getName(), methodName, totalTimeMillis, jsonConverter.writeValueAsString(retVal));
        return retVal;
    }


}
