package com.thread.queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;/**
* Java线程：线程池-自定义线程池
*
* @author Administrator 2009-11-4 23:30:44
*/
public class QueueTest {
        public static void main(String[] args) {
                //创建等待队列
                BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
                //创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
                ThreadPoolExecutor pool = new ThreadPoolExecutor(10,10,10,TimeUnit.MILLISECONDS,bqueue);
                //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
                Thread t1 = new MyThread();
                Thread t2 = new MyThread();
                Thread t3 = new MyThread();
                Thread t4 = new MyThread();
                Thread t5 = new MyThread();
                Thread t6 = new MyThread();
                Thread t7 = new MyThread();
                //将线程放入池中进行执行
                pool.execute(t1);
                pool.execute(t2);
                pool.execute(t3);
                pool.execute(t4);
                pool.execute(t5);
                pool.execute(t6);
                pool.execute(t7);
                //关闭线程池
                pool.shutdown();
        }
} class MyThread extends Thread {
        @Override
        public void run() {
                System.out.println(Thread.currentThread().getName() + "正在执行。。。");
                try {
                        Thread.sleep(100L);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }
}