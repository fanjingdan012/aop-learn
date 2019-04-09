package com.fjd.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;

import java.io.IOException;

//Transaction
@Service("sampleService")
class AppService {
    public void doBusiness() throws  Exception{
        System.out.println("do business");
        throw new IOException();
    }
}

//Aspect
@Component
@Aspect
class AppAspect {

    @Before(value = "execution(void *.doBusiness())")
    public void logBefore(JoinPoint joinPoint) {
        //new IOException().printStackTrace();
        System.out.println("==before " + joinPoint.getSignature());
    }

    @After(value = "execution(void *.doBusiness())")
    public void logAfter() {
        //new IOException().printStackTrace();
        System.out.println("==after");
    }

    @Around(value = "execution(void *.doBusiness())")
    public void logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("==around before");
        pjp.proceed();
        System.out.println("==around after");
    }


    //@Pointcut("execution(* com.test.spring.aop.pointcutexp..JoinPointObjP2.*(..))")
    //@Pointcut("within(com.test.spring.aop.pointcutexp..*)")
    //@Pointcut("this(com.test.spring.aop.pointcutexp.Intf)")
    //@Pointcut("target(com.test.spring.aop.pointcutexp.Intf)")
    //@Pointcut("@within(org.springframework.transaction.annotation.Transactional)")
    //@Pointcut("within(com.fjd.spring.*)")
    //@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    //@Pointcut("args(String)")
    @Pointcut("execution(void *.doBusiness())")
    public void pointcut() {
        System.out.println("==pointcut");// will not execute
    }

    @Before("pointcut()")
    @AdviceName("pointcutBefore")
    public void pointcutBefore(JoinPoint joinPoint) {
        System.out.println("==pointcut before " + joinPoint.getSignature());
    }

    @AfterThrowing(pointcut="execution(void *.doBusiness())",throwing = "ex")
    public void doRecoveryActions(JoinPoint joinPoint, Throwable ex) {
        System.out.println("==pointcut in exception " + joinPoint.getSignature());
    }


}


@ComponentScan(basePackages = {"com.fjd.spring"})
@EnableAspectJAutoProxy
public class App {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        AppService appService = context.getBean(AppService.class);
        System.out.println("SampleService implementation： " + appService.getClass().getSimpleName());
        appService.doBusiness();

    }

}






