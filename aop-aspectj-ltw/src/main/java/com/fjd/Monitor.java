package com.fjd;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;  
  
@Aspect  
public class Monitor {  
  
    @Pointcut("execution(* con.fjd.SecuredMethod.*(..))")
    public void anyService(){}  
  
      
    @Before("anyService()")
    public void log(JoinPoint joinPoint){  
        System.out.println("before Service Method " + joinPoint.getSignature().getName() + " Invocation!");
    }  
}  