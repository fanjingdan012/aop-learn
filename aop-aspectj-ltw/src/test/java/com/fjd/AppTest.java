package com.fjd;


import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 

{
    @Test
    public void testMethod() throws Exception {
        SecuredMethod service = new SecuredMethod();
        service.unlockedMethod();
        service.lockedMethod();
    }

}
