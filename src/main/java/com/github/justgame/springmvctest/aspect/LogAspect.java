package com.github.justgame.springmvctest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xiecongle
 * @date 2020/6/3
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(log)")
    public void aroundLogPointcut(Log log) {

    }

    @Around(value = "aroundLogPointcut(log)")
    public Object aroundLog(ProceedingJoinPoint pjp, Log log) throws Throwable {
        System.out.println("around before");
        Object o = pjp.proceed();
        System.out.println("around after");
        return o;
    }
}
