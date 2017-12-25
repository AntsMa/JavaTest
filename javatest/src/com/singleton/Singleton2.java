package com.singleton;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.27 11:26
 */
public class Singleton2 {
    private Singleton2(){}

    private static Singleton2 instance;

   /* public static  Singleton2 getInstance(){
        if(null == instance){
            instance = new Singleton2();
        }
        return instance;
    }*/

   /* public static synchronized Singleton2 getInstance(){
        if(null == instance){
            instance = new Singleton2();
        }
        return instance;
    }*/

    public static  Singleton2 getInstance(){
        if(null == instance){
            synchronized (Singleton2.class){
                if(null == instance){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
