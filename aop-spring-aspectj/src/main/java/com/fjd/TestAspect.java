package com.fjd;
//
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Aspect // FOR AOP
//@Order(-99) // 控制多个Aspect的执行顺序，越小越先执行
//@Component
//public class TestAspect {
//
// @Before("@annotation(test)")// 拦截被TestAnnotation注解的方法；如果你需要拦截指定package指定规则名称的方法，可以使用表达式execution(...)，具体百度一下资料一大堆
// public void beforeTest(JoinPoint point, TestAnnotation test) throws Throwable {
//  System.out.println("beforeTest:" + test.name());
// }
//
// @After("@annotation(test)")
// public void afterTest(JoinPoint point, TestAnnotation test) {
//  System.out.println("afterTest:" + test.name());
// }
//
//}



public  class TestAspect{
    @Before("execution(* *.hello(..))")
    public void aBefore(JoinPoint joinPoint) throws Throwable {

        System.out.println("before...");
    }

    @Around("execution(* *.hello(..))")
    public void aAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String key = proceedingJoinPoint.getSignature().toString();
        System.out.println( "around before: " + key);
        proceedingJoinPoint.proceed();
        System.out.println( "around after: " + key);
    }

    protected void hello(String name) {
        System.out.println("hello "+name);
    }




    public static void main(String []args){
        TestAspect ta = new TestAspect();
        ta.hello("fjd");
    }
}