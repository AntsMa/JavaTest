package com.thread.conditionT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
* Java线程：条件变量
*
* @author leizhimin 2009-11-5 10:57:29
*/
public class lockConTest {
        public static void main(String[] args) {
                //创建并发访问的账户
                MyCount myCount = new MyCount("95599200901215522", 5000);
                //创建一个线程池
                ExecutorService pool = Executors.newFixedThreadPool(2);
                Thread t1 = new DrawThread("张三", myCount, 4000);
                Thread t2 = new SaveThread("李四", myCount, 7000);
                Thread t7 = new SaveThread("老六", myCount, 1600);
                Thread t3 = new DrawThread("王五", myCount, 5700);
                Thread t4 = new SaveThread("老张", myCount, 600);
                Thread t5 = new DrawThread("老牛", myCount, 1300);
                Thread t6 = new SaveThread("胖子", myCount, 300);
                //执行各个线程
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
class SaveThread extends Thread {
        private String name;                //操作人
        private MyCount myCount;        //账户
        private int x;                            //存款金额

        SaveThread(String name, MyCount myCount,int x) {
                this.name = name;
                this.myCount = myCount;
                this.x = x;
        } 
        
        public void run() {
                myCount.saving(x, name);
        }
} 

/**
* 取款线程类
*/
class DrawThread extends Thread {
        private String name;                //操作人
        private MyCount myCount;        //账户
        private int x;                            //存款金额

        DrawThread(String name, MyCount myCount,int x) {
                this.name = name;
                this.myCount = myCount;
                this.x = x;
        }
        public void run() {
                myCount.drawing(x, name);
        }
} 

/**
* 普通银行账户，不可透支
*/
class MyCount {
        private String oid;                        //账号
        private int cash;                            //账户余额
        private Lock lock =new ReentrantLock();           //账户锁
        private Condition _save = lock.newCondition();    //存款条件
        private Condition _draw = lock.newCondition();    //取款条件

        MyCount(String oid,int cash) {
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
                lock.lock();
                //获取锁
                if (x > 0) {
                        cash += x;                    //存款
                        System.out.println(System.nanoTime()+name + "存款" + x +"，当前余额为" + cash);
                }
                _draw.signalAll();            //唤醒所有等待线程。
                lock.unlock();                    //释放锁
        } 
        
        /**
         * 取款
         *
         * @param x        操作金额
         * @param name 操作人
         */
        public void drawing(int x, String name) {
                lock.lock();                                 //获取锁
                try {
                       /* if (cash - x < 0) {
                        	System.out.println(System.nanoTime()+name+"取款阻塞1:"+x+",当前余额"+cash);
                                _draw.await(); 
                                //阻塞取款操作
                            System.out.println(System.nanoTime()+name+"取款阻塞2:"+x+",当前余额"+cash);
                        } else {
                                cash -= x;                     //取款
                                System.out.println(System.nanoTime()+name + "取款" + x +"，当前余额为" + cash);
                        }*/
                        cashDeal( name, x);
                        _save.signalAll();             //唤醒所有存款操作
                } catch (InterruptedException e) {
                        e.printStackTrace();
                } finally {
                        lock.unlock();                     //释放锁
                }
        }


        public void cashDeal(String name,int x) throws InterruptedException {
                if (cash - x < 0){
                        System.out.println(System.nanoTime()+name+"取款阻塞1:"+x+",当前余额"+cash);
                        _draw.await();
                        //阻塞取款操作
                        cashDeal( name, x);
                }else{
                        cash -= x;                     //取款
                        System.out.println(System.nanoTime()+name + "取款" + x +"，当前余额为" + cash);
                }

        }

}