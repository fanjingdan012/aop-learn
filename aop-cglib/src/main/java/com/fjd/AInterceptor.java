package com.fjd;

import java.lang.reflect.Method;
 
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AInterceptor implements MethodInterceptor{
 

	public Object intercept(Object obj, Method method, Object[] params,
			MethodProxy proxy) throws Throwable {
		System.out.println("Before");
		Object result = proxy.invokeSuper(obj, params);
		System.out.println("After "+result);
		return result;
	}
 
 
}
