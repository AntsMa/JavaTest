package com.thread.conditionT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/* Java线程：改为同步代码块
*
* @author leizhimin 2009-11-5 10:57:29
*/
public class SynchronizationCodeTest {
        public static void main(String[] args) {
                //创建并发访问的账户
                MyCount2 myCount2 = new MyCount2("95599200901215522", 5000);
                //创建一个线程池
                ExecutorService pool = Executors.newFixedThreadPool(2);
           /*     Thread t1 = new SaveThread2("张三", MyCount2, 2000);
                Thread t2 = new SaveThread2("李四", MyCount2, 3600);
                Thread t3 = new DrawThread2("王五", MyCount2, 2700);
                Thread t4 = new SaveThread2("老张", MyCount2, 600);
                Thread t5 = new DrawThread2("老牛", MyCount2, 1300);
                Thread t6 = new DrawThread2("胖子", MyCount2, 800);*/
                Thread t1 = new DrawThread2("张三", myCount2, 4000);
                Thread t2 = new SaveThread2("李四", myCount2, 7000);
                Thread t7 = new SaveThread2("老六", myCount2, 1600);
                Thread t3 = new DrawThread2("王五", myCount2, 5700);
                Thread t4 = new SaveThread2("老张", myCount2, 600);
                Thread t5 = new DrawThread2("老牛", myCount2, 1300);
                Thread t6 = new SaveThread2("胖子", myCount2, 300);
                //执行各个线程
               /* pool.execute(t1);
                pool.execute(t2);
                pool.execute(t3);
                pool.execute(t4);
                pool.execute(t5);
                pool.execute(t6);*/
                pool.execute(t3);
                pool.execute(t1);
                pool.execute(t2);
                pool.execute(t4);
                pool.execute(t5);
                pool.execute(t6);
                pool.execute(t7);
                //关闭线程池
                pool.shutdown();
        }
} 

/**
* 存款线程类
*/
class SaveThread2 extends Thread {
        private String name;                //操作人
        private MyCount2 MyCount2;        //账户
        private int x;                            //存款金额

        SaveThread2(String name, MyCount2 MyCount2,int x) {
                this.name = name;
                this.MyCount2 = MyCount2;
                this.x = x;
        } 
        public void run() {
                MyCount2.saving(x, name);
        }
}

/**
* 取款线程类
*/
class DrawThread2 extends Thread {
        private String name;                //操作人
        private MyCount2 MyCount2;        //账户
        private int x;                            //存款金额

        DrawThread2(String name, MyCount2 MyCount2,int x) {
                this.name = name;
                this.MyCount2 = MyCount2;
                this.x = x;
        } 
        public void run() {
                MyCount2.drawing(x, name);
        }
} 

/**
* 普通银行账户，不可透支
*/
class MyCount2 {
        private String oid;                        //账号
        private int cash;                            //账户余额

        MyCount2(String oid,int cash) {
                this.oid = oid;
                this.cash = cash;
        }
        
        /**
         * 存款
         *
         * @param x        操作金额
         * @param name 操作人
         */
        public void saving(int x, String name) {
                if (x > 0) {
                        synchronized (this) {
                                cash += x;                    //存款
                                System.out.println(System.nanoTime()+name + "存款" + x +"，当前余额为" + cash);
                                notifyAll();            //唤醒所有等待线程。
                        }
                }
        }
        
        /**
         * 取款
         *
         * @param x        操作金额
         * @param name 操作人
         */
        public synchronized void drawing(int x, String name) {
                synchronized (this) {
                        /*if (cash - x < 0) {
                        	System.out.println(System.nanoTime()+name + "取款,阻塞1：" + x +"，当前余额为" + cash);
                                try {
                                        wait();
                                } catch (InterruptedException e1) {
                                        e1.printStackTrace();
                                }
                              	System.out.println(System.nanoTime()+name + "取款,阻塞2：" + x +"，当前余额为" + cash);
                        } else {
                                cash -= x;                     //取款
                                System.out.println(System.nanoTime()+name + "取款" + x +"，当前余额为" + cash);
                        }*/
                        drawingDeal(x,name);
                }
                notifyAll();             //唤醒所有存款操作
        }

        public  void drawingDeal(int x,String name){
                if (cash - x < 0) {
                        System.out.println(System.nanoTime()+name + "取款,阻塞1：" + x +"，当前余额为" + cash);
                        try {
                                wait();
                        } catch (InterruptedException e1) {
                                e1.printStackTrace();
                        }
                        drawingDeal(x,name);
                } else {
                        cash -= x;                     //取款
                        System.out.println(System.nanoTime()+name + "取款" + x +"，当前余额为" + cash);
                }
        }
}