package com.thread.conditionT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/* Java�̣߳���Ϊͬ�������
*
* @author leizhimin 2009-11-5 10:57:29
*/
public class SynchronizationCodeTest {
        public static void main(String[] args) {
                //�����������ʵ��˻�
                MyCount2 myCount2 = new MyCount2("95599200901215522", 5000);
                //����һ���̳߳�
                ExecutorService pool = Executors.newFixedThreadPool(2);
           /*     Thread t1 = new SaveThread2("����", MyCount2, 2000);
                Thread t2 = new SaveThread2("����", MyCount2, 3600);
                Thread t3 = new DrawThread2("����", MyCount2, 2700);
                Thread t4 = new SaveThread2("����", MyCount2, 600);
                Thread t5 = new DrawThread2("��ţ", MyCount2, 1300);
                Thread t6 = new DrawThread2("����", MyCount2, 800);*/
                Thread t1 = new DrawThread2("����", myCount2, 4000);
                Thread t2 = new SaveThread2("����", myCount2, 7000);
                Thread t7 = new SaveThread2("����", myCount2, 1600);
                Thread t3 = new DrawThread2("����", myCount2, 5700);
                Thread t4 = new SaveThread2("����", myCount2, 600);
                Thread t5 = new DrawThread2("��ţ", myCount2, 1300);
                Thread t6 = new SaveThread2("����", myCount2, 300);
                //ִ�и����߳�
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
                //�ر��̳߳�
                pool.shutdown();
        }
} 

/**
* ����߳���
*/
class SaveThread2 extends Thread {
        private String name;                //������
        private MyCount2 MyCount2;        //�˻�
        private int x;                            //�����

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
* ȡ���߳���
*/
class DrawThread2 extends Thread {
        private String name;                //������
        private MyCount2 MyCount2;        //�˻�
        private int x;                            //�����

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
* ��ͨ�����˻�������͸֧
*/
class MyCount2 {
        private String oid;                        //�˺�
        private int cash;                            //�˻����

        MyCount2(String oid,int cash) {
                this.oid = oid;
                this.cash = cash;
        }
        
        /**
         * ���
         *
         * @param x        �������
         * @param name ������
         */
        public void saving(int x, String name) {
                if (x > 0) {
                        synchronized (this) {
                                cash += x;                    //���
                                System.out.println(System.nanoTime()+name + "���" + x +"����ǰ���Ϊ" + cash);
                                notifyAll();            //�������еȴ��̡߳�
                        }
                }
        }
        
        /**
         * ȡ��
         *
         * @param x        �������
         * @param name ������
         */
        public synchronized void drawing(int x, String name) {
                synchronized (this) {
                        /*if (cash - x < 0) {
                        	System.out.println(System.nanoTime()+name + "ȡ��,����1��" + x +"����ǰ���Ϊ" + cash);
                                try {
                                        wait();
                                } catch (InterruptedException e1) {
                                        e1.printStackTrace();
                                }
                              	System.out.println(System.nanoTime()+name + "ȡ��,����2��" + x +"����ǰ���Ϊ" + cash);
                        } else {
                                cash -= x;                     //ȡ��
                                System.out.println(System.nanoTime()+name + "ȡ��" + x +"����ǰ���Ϊ" + cash);
                        }*/
                        drawingDeal(x,name);
                }
                notifyAll();             //�������д�����
        }

        public  void drawingDeal(int x,String name){
                if (cash - x < 0) {
                        System.out.println(System.nanoTime()+name + "ȡ��,����1��" + x +"����ǰ���Ϊ" + cash);
                        try {
                                wait();
                        } catch (InterruptedException e1) {
                                e1.printStackTrace();
                        }
                        drawingDeal(x,name);
                } else {
                        cash -= x;                     //ȡ��
                        System.out.println(System.nanoTime()+name + "ȡ��" + x +"����ǰ���Ϊ" + cash);
                }
        }
}