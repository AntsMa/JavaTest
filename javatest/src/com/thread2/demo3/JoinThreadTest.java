package com.thread2.demo3;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.06.13 15:29
 */
public class JoinThreadTest {
    public static int i = 0;
    public static void add(){
        i++;
    }

    public static void main(String[] args) {


        JoinThreadTest joinThread = new JoinThreadTest();
        for (int j = 0; j < 10; j++) {
            joinThread.add();
        }
        JoinThreadTest joinThread1 = new JoinThreadTest();
        for (int j = 0; j < 10; j++) {
            joinThread1.add();
        }
        System.out.println(JoinThreadTest.i);
    }
}
