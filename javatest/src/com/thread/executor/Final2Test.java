package com.thread.executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;import java.util.concurrent.ScheduledExecutorService;
/**
* Java线程：线程池-
*
* @author Administrator 2009-11-4 23:30:44
*/
public class Final2Test {
        public static void main(String[] args) {
                //创建一个可重用固定线程数的线程池
//                ExecutorService pool = Executors.newSingleThreadExecutor();
                ExecutorService pool = Executors.newSingleThreadExecutor();
            //创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
//            ExecutorService pool = Executors.newCachedThreadPool();
//                ExecutorService pool = Executors.newFixedThreadPool(1);
        	
        	//创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
                Thread t1 = new MyThread2();
                Thread t2 = new MyThread2();
                Thread t3 = new MyThread2();
                Thread t4 = new MyThread2();
                Thread t5 = new MyThread2();
                //将线程放入池中进行执行
                pool.execute(t1);
                pool.execute(t2);
                pool.execute(t3);
                pool.execute(t4);
                pool.execute(t5);
                //关闭线程池
                pool.shutdown();
//                pool2.shutdown();
        }
} 
class MyThread2 extends Thread{
        @Override
        public void run() {
                System.out.println(Thread.currentThread().getName()+"正在执行。。。");
        }
}
