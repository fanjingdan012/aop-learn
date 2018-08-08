package com.fjd;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import org.junit.Test;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.NoOp;

import java.util.HashMap;

public class ATest {
    @Test
    public void testFixedValue0(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(A.class);
        enhancer.setCallback(new FixedValue() {
            public Object loadObject() throws Exception {
                System.out.println("Fixed result");
                Object obj = "Hello fjd";
                return obj;
            }
        });
        A proxy = (A) enhancer.create();
        System.out.println(proxy.test("fjd"));
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
    }
    @Test
    public void testFixedValue(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(A.class);
        enhancer.setCallback(new AResultFixed() );
        A proxy = (A) enhancer.create();
        System.out.println(proxy.getClass().getMethods()[0]);
        System.out.println(proxy.getClass().getDeclaredMethods()[0]);
        System.out.println(proxy.test("fjd"));
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
    }

    @Test
    public void testIntercepter(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(HashMap.class);
        enhancer.setCallback(new AInterceptor());
        HashMap targetObject2=(HashMap)enhancer.create();
       // System.out.println(targetObject2);
        targetObject2.put("fjd","fjdvalue");
        //System.out.println();

    }
    @Test
    public void testFilter(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(A.class);
        CallbackFilter callbackFilter = new AMethodCallbackFilter();

        /**
         * (1)callback1：方法拦截器
         (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
         (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
         */
        Callback noopCb=NoOp.INSTANCE;
        Callback callback1=new AInterceptor();
        Callback fixedValue=new AResultFixed();
        Callback[] cbarray=new Callback[]{callback1,noopCb,fixedValue};
        //enhancer.setCallback(new TargetInterceptor());
        enhancer.setCallbacks(cbarray);
        enhancer.setCallbackFilter(callbackFilter);
        A targetObject2=(A)enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.test("fjd"));
        System.out.println(targetObject2.test1("fjd1"));


    }

}
