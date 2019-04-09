package com.fjd;

public class SecuredMethod {
 
    @Secured(isLocked = true)
    public void lockedMethod() {
        System.out.println("locked Method");
    }
 
    @Secured(isLocked = false)
    public void unlockedMethod() {
        System.out.println("unlocked Method");
    }
}