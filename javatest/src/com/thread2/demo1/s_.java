package com.thread2.demo1;

/**
 * Created by shichen.ma on 2017/8/22.
 */
public class s_ extends  Thread{
    public synchronized void isSyncA(){
        System.out.println("AAAA");
    }
    public synchronized void isSyncB(){
        System.out.println("BB");
    }
    public static synchronized void cSyncA(){
        System.out.println("static_AAAA");
    }
    public static synchronized void cSyncB(){
        System.out.println("static_BBB");
    }
}
