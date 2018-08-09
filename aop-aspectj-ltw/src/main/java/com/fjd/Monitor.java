package com.fjd;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;  
  
@Aspect  
public class Monitor {  
  
    @Pointcut("execution(* quickstart.service.impl.*.*(..))")  
    public void anyService(){}  
  
      
    @Before("quickstart.aspectj.Monitor.anyService()")  
    public void log(JoinPoint joinPoint){  
        System.out.println("Service Method " + joinPoint.getSignature().getName() + " Invocation!");  
    }  
}  