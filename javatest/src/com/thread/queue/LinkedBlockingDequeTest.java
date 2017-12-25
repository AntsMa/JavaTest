package com.thread.queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
* Java�̣߳�������-��������
*
* @author leizhimin 2009-11-5 14:59:15
*/
public class LinkedBlockingDequeTest {
        public static void main(String[] args)throws InterruptedException {
                BlockingQueue bqueue = new ArrayBlockingQueue(20);
                for (int i = 0; i < 30; i++) {
                        //��ָ��Ԫ����ӵ��˶����У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ����
                        bqueue.put(i);
                        System.out.println("�����������������Ԫ��:" + i);
                }
                System.out.println("���򵽴����н����������˳�----");
        }

        public static void test() throws InterruptedException {
                BlockingQueue blockingQueue = new ArrayBlockingQueue(20);
                for (int i = 0; i < 25; i++) {
                        blockingQueue.put(i);
                        System.out.println("���������������Ԫ�أ�"+i);

                }
                System.out.println("���򵽴����н����������˳�");
        }
}