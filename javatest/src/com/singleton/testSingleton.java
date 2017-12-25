package com.singleton;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.27 14:15
 */
public class testSingleton {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Singleton2 singleton1 = new Singleton2();
        Class<?> singleTon = Class.forName("com.singleton.Singleton1");
        System.out.println(singleTon.newInstance().getClass().getName());
    }
}
