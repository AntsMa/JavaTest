package com.thread.waits;
/**
* ��ȡ�����������
*
* @author leizhimin 2008-9-20 11:15:22
*/
public class ReaderResult extends Thread {
        Calculator c;

        public ReaderResult(Calculator c) {
                this.c = c;
        }

        public void run() {
                synchronized (c) {
                        try {
                                System.out.println(Thread.currentThread() +"_"+ currentThread().getName()+ "�ȴ�������������");
                                c.wait();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread() +"_"+ currentThread().getName()+ "������Ϊ��" + c.total);
                }
        }

        public static void main(String[] args) {
                Calculator calculator = new Calculator();

                //���������̣߳��ֱ��ȡ������
                new ReaderResult(calculator).start();
                new ReaderResult(calculator).start();
                new ReaderResult(calculator).start();
//                //���������߳�
                calculator.start();
        }
}