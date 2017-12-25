package com.thread.demo1;

import java.util.Date;

/**
* Java线程：线程的同步
*
* @author leizhimin 2009-11-4 11:23:32
*/
public class UnSynchronizedTest {
        public static void main(String[] args) {
                User1 u = new User1("张三", 100);
                MyThread1 t1 = new MyThread1("线程A", u, 20);
                MyThread1 t2 = new MyThread1("线程B", u, -60);
                MyThread1 t3 = new MyThread1("线程C", u, -80);
                MyThread1 t4 = new MyThread1("线程D", u, -30);
                MyThread1 t5 = new MyThread1("线程E", u, 32);
                MyThread1 t6 = new MyThread1("线程F", u, 21);

                t1.start();

                t2.start();
                t3.start();
                t4.start();
                t5.start();
                t6.start();
        }
}

class MyThread1 extends Thread {
        private User1 u;
        private int y = 0;

        MyThread1(String name, User1 u,int y) {
                super(name);
                this.u = u;
                this.y = y;
        } 
        
        public void run() {
                u.oper(y);
        }
}

class User1 {
        private String code;
        private int cash;

        User1(String code,int cash) {
                this.code = code;
                this.cash = cash;
        } 
        
        public String getCode() {
                return code;
        }
        
        public void setCode(String code) {
                this.code = code;
        } 
/**
         * 业务方法
         * @param x 添加x万元
         */
        public  void oper(int x) {
//                try {
//                        Thread.sleep(10L);
                        System.out.println(System.nanoTime() +"---"+ Thread.currentThread().getName() +",cash:"+this.cash);
                       System.out.println( System.nanoTime() +"---" +Thread.currentThread().getName()+",cash:"+this.cash+",x:"+x+","+(this.cash = this.cash+ x)); 
                        System.out.println(System.nanoTime() + "---"+Thread.currentThread().getName() +","+ ",运行结束，增加“" + x +"”，当前用户账户余额为：" + cash);
//                        Thread.sleep(10L);
//                } catch (InterruptedException e) {
//                        e.printStackTrace();
//                }
        }

        @Override

        public String toString() {
                return"User1{" +
                                "code='" + code + '\'' +
                                ", cash=" + cash + 
                                '}';
        }
}