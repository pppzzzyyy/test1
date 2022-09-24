package com.example.test1.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : panzhenye
 * @date : 2022/9/24 17:23
 */
@Aspect
@Component
@Slf4j
public class MethodTimeConsuming {

    @Pointcut("execution(* com.example.test1.controller.TestController.*())")
    public void test(){};

    @Around(value = "test()")
    public Object methodTimeConsuming(ProceedingJoinPoint joinPoint) throws Exception {
        try {
            long l = System.currentTimeMillis();
            Object proceed = joinPoint.proceed();
            long l1 = System.currentTimeMillis();
            log.info("用时：{}", l1 - l);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
