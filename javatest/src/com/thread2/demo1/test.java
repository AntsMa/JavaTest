package com.thread2.demo1;

/**
 * Created by shichen.ma on 2017/8/22.
 */
public class test {
    public static void main(String[] args) {
        s_ s1 = new s_();
        s1.start();
//        s1.isSyncA();
//        s1.isSyncB();
        s_ s2 = new s_();
        s2.isSyncA();
        s2.isSyncB();
    }
}
