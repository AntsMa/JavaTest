package com.thread.wait;
/**
* 计算输出其他线程锁计算的数据
*
* @author leizhimin 2008-9-15 13:20:38
*/
public class ThreadA {
    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
//        ThreadC c = new ThreadC();
//        c.start();

        b.start();

      /*  System.out.println("等待对象b完成计算。。。");
        synchronized(b){
            b.wait();
        }
        System.out.println("b对象计算的总和是：" + b.total);*/

        //启动计算线程
        //线程A拥有b对象上的锁。线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
       synchronized (b) {
            try {
                System.out.println("等待对象b完成计算。。。");
//                System.out.println("等待对象c完成计算。。。");
//                当前线程A等待
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("C对象计算的总和是：" + b.total);
            System.out.println("b对象计算的总和是：" + b.total);
        }


    }
}