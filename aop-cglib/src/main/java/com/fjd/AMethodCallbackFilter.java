package com.fjd;

import java.lang.reflect.Method;
 
import net.sf.cglib.proxy.CallbackFilter;
/**
 * 回调方法过滤
 * @author zghw
 *
 */
public class AMethodCallbackFilter implements CallbackFilter {
 
	/**
     * 过滤方法
	 * 返回的值为数字，代表了Callback数组中的索引位置，要到用的Callback
	 */
	public int accept(Method method) {
		if(method.getName().equals("test")){
			System.out.println("filter test ==0");
			return 0;
		}
		if(method.getName().equals("test1")){
			System.out.println("filter test1 ==1");
			return 1;
		}
		return 0;
	}
 
}
