package com.thread.executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;import java.util.concurrent.ScheduledExecutorService;
/**
* Java�̣߳��̳߳�-
*
* @author Administrator 2009-11-4 23:30:44
*/
public class Final2Test {
        public static void main(String[] args) {
                //����һ�������ù̶��߳������̳߳�
//                ExecutorService pool = Executors.newSingleThreadExecutor();
                ExecutorService pool = Executors.newSingleThreadExecutor();
            //����һ���ɸ�����Ҫ�������̵߳��̳߳أ���������ǰ������߳̿���ʱ���������ǡ�
//            ExecutorService pool = Executors.newCachedThreadPool();
//                ExecutorService pool = Executors.newFixedThreadPool(1);
        	
        	//����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
                Thread t1 = new MyThread2();
                Thread t2 = new MyThread2();
                Thread t3 = new MyThread2();
                Thread t4 = new MyThread2();
                Thread t5 = new MyThread2();
                //���̷߳�����н���ִ��
                pool.execute(t1);
                pool.execute(t2);
                pool.execute(t3);
                pool.execute(t4);
                pool.execute(t5);
                //�ر��̳߳�
                pool.shutdown();
//                pool2.shutdown();
        }
} 
class MyThread2 extends Thread{
        @Override
        public void run() {
                System.out.println(Thread.currentThread().getName()+"����ִ�С�����");
        }
}
