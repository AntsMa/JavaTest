package com.reflect.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.22 11:35
 */
public class MyInvocationHandler implements InvocationHandler{

    private Object obj = null;

    public Object buind(Object obj){
        this.obj = obj ;
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object temp = method.invoke(this.obj,args);
        return temp;
    }
}
