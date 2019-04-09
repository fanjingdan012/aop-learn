package com.fjd;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecuredMethodAspect {
    @Pointcut("@annotation(Secured)")
    public void callAt(Secured secured) {
    }
 
    @Around("callAt(secured)")
    public Object around(ProceedingJoinPoint pjp,      Secured secured) throws Throwable {
        System.out.println("around call at secured");
        return secured.isLocked() ? null : pjp.proceed();
    }
}