package com.fjd;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author zxf
 * 演示aop测试类
 */
@Controller
public class UserAction {

    public void queryUsers(){

        System.out.println("查询所有用户【all users list】");
    }

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-aop.xml");

        UserAction userAction = (UserAction)ctx.getBean("userAction");
        userAction.queryUsers();

        ctx.destroy();
    }
}