package com.proxy.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicHumenProxy implements InvocationHandler
{
    private Object taget;

    public DynamicHumenProxy(Object taget){
        this.taget = taget;
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