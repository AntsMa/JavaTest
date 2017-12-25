package com.thread.AtomicLongTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicLong;/**
* Java�̣߳�������-ԭ����
*
* @author leizhimin 2009-11-6 9:53:11
*/
public class AtomicLongTest {
        public static void main(String[] args) {
                ExecutorService pool = Executors.newFixedThreadPool(2);

                ExecutorService ppp = Executors.newFixedThreadPool(111);

                Lock lock = new ReentrantLock(false);
                Runnable t1 = new MyRunnable1("����", 2000,lock);
                Runnable t2 = new MyRunnable1("����", 3600,lock);
                Runnable t3 = new MyRunnable1("����", 2700,lock);
                Runnable t4 = new MyRunnable1("����", 600,lock);
                Runnable t5 = new MyRunnable1("��ţ", 1300,lock);
                Runnable t6 = new MyRunnable1("����", 800,lock);
                //ִ�и����߳�
                pool.execute(t1);
                pool.execute(t2);
                pool.execute(t3);
                pool.execute(t4);
                pool.execute(t5);
                pool.execute(t6);
                //�ر��̳߳�
                pool.shutdown();
        }
} 

class MyRunnable1 implements Runnable {
        private static AtomicLong aLong =new AtomicLong(10000);        //ԭ������ÿ���̶߳��������ɲ���
        private String name;                //������
        private int x;                            //��������
        private Lock lock;

        MyRunnable1(String name,int x,Lock lock) {
                this.name = name;
                this.x = x;
                this.lock = lock;
        }
        public void run() {
                lock.lock();
                System.out.println(name + "ִ����" + x +"����ǰ��" + aLong.addAndGet(x));
                lock.unlock();
        }
}
