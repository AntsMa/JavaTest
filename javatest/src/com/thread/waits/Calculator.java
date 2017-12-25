package com.thread.waits;
/**
* 计算线程
*
* @author leizhimin 2008-9-20 11:15:46
*/
public class Calculator extends Thread {
        int total;

        public void run() {
                synchronized (this) {
                        for (int i = 0; i < 101; i++) {
                                total += i;
                        }
                }
                //通知所有在此对象上等待的线程
                notifyAll();
        }
}