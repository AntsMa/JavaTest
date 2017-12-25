package com.proxy.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicHumenProxy2 implements InvocationHandler
{
    private Object taget;

    public DynamicHumenProxy2(Object taget){
        this.taget = taget;
    }

    public <T> T getProxy(){
        return (T)Proxy.newProxyInstance(
                taget.getClass().getClassLoader(),
                taget.getClass().getInterfaces(),
                this
                );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(taget,args);
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