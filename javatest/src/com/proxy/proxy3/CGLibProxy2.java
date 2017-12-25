package com.proxy.proxy3;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by shichen.ma on 2017/7/27.
 */
public class CGLibProxy2 implements MethodInterceptor {

    private CGLibProxy2(){}
    private static CGLibProxy2 instance = new CGLibProxy2();

    public static CGLibProxy2 getInstance(){
        return instance;
    }

    public <T> T getProxy(Class<T> cla){
        return (T) Enhancer.create(cla,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o,args);
        after();
        return result;
    }

    private void before(){
        System.out.println("cook");
    }

    private void after(){
        System.out.println("swap");
    }



}
