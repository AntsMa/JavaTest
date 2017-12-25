package com.proxy.proxy3;

import java.lang.reflect.Proxy;

/**
 * Created by shichen.ma on 2017/7/27.
 */
public class testProxy {
    public static void main(String[] args) {
        staticProxy();
        dynamicProxy1();
        dynamicProxy2();
        cglibProxy();
        cglibProxy2();
    }

    public static void staticProxy(){
        System.out.println("----------staticProxy------ start------------");
        staticHumenProxy staticHumenProxy = new staticHumenProxy();
        staticHumenProxy.eat("staticProxy");
        System.out.println("------staticProxy------- end-----");
    }


    public  static void dynamicProxy1(){
        System.out.println("------dynamicProxy1------- start-----");
        Humen humen = new HumenImpl();
        DynamicHumenProxy dynamicHumenProxy = new DynamicHumenProxy(humen);
        Humen humenProxy =(Humen) Proxy.newProxyInstance(humen.getClass().getClassLoader(),humen.getClass().getInterfaces(),dynamicHumenProxy);
        humenProxy.eat("dynamicProxy1");
        System.out.println("------dynamicProxy1------- end-----");
    }

    public  static void dynamicProxy2(){
        System.out.println("------dynamicProxy2 ------ start-----");
        Humen humen = new HumenImpl();
        DynamicHumenProxy2 dynamicHumenProxy2 = new DynamicHumenProxy2(humen);
        Humen humenProxy =(Humen) dynamicHumenProxy2.getProxy();
        humenProxy.eat("dynamicProxy2");
        System.out.println("------dynamicProxy2------- end-----");
    }

    public  static void cglibProxy(){
        System.out.println("------cglibProxy ------ start-----");
        CGLibProxy cgLibProxy = new CGLibProxy();
        Humen humen = cgLibProxy.getProxy(HumenImpl.class);
        humen.eat("cglibProxy");
        System.out.println("------cglibProxy------- end-----");
    }

    public  static void cglibProxy2(){
        System.out.println("------cglibProxy2 ------ start-----");
       Humen humen = CGLibProxy2.getInstance().getProxy(HumenImpl.class);
        humen.eat("cglibProxy2");
        System.out.println("------cglibProxy2------- end-----");
    }

}
