package com.fjd;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AppAspect {
    @Pointcut("execution(* com.fjd.App.sayHello(..))")
    public void jointPoint() {
    }

    @Before("jointPoint()")
    public void before() {
        System.out.println("AppAspect before ");
    }

    @After("jointPoint()")
    public void after() {
        System.out.println("AppAspect after ");
    }
}
