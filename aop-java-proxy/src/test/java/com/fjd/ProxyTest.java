package com.fjd;

import org.junit.Test;
  

public class ProxyTest {  
  
    @Test  
    public void testProxy() throws Throwable {  
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();
    }
    @Test
    public void testGenerateProxyClass() {
        ProxyGeneratorUtils.writeProxyClassToHardDisk("./$Proxy11.class");
    }
}  