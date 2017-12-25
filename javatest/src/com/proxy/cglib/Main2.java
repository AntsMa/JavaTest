package com.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;


public class Main2 {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService o = (UserService)enhancer.create();
        System.out.println(o.getName("chen",3));
        System.out.println(o.getAge(13,5));

    }
}