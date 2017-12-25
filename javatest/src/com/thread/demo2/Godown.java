package com.thread.demo2;
/**
* �ֿ�
*/
public class Godown {
        public static final int max_size = 100;//�������
        public int curnum;    //��ǰ�����

        Godown() {
        }

        Godown(int curnum) {
                this.curnum = curnum;
        }
        
        /**
         * ����ָ�������Ĳ�Ʒ
         *
         * @param neednum
         */
        public synchronized void produce(int neednum) {
                //�����Ƿ���Ҫ����
                while (neednum + curnum > max_size) {
                        System.out.println(System.nanoTime()+"---"+Thread.currentThread().getName()+"----Ҫ�����Ĳ�Ʒ����" + neednum +"�����ֿ�ʣ������" + (max_size - curnum) +"����ʱ����ִ����������!");
                        try {
                        	System.out.println(System.nanoTime()+"---"+Thread.currentThread().getName()+"---produce����----"+"curnum:"+curnum +"__"+"neednum:"+neednum);
                                //��ǰ�������̵߳ȴ�
                                wait();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
                //�����������������������������򵥵ĸ��ĵ�ǰ�����
                curnum += neednum;
                System.out.println(System.nanoTime()+"---"+Thread.currentThread().getName()+"----�Ѿ�������" + neednum +"����Ʒ���ֲִ���Ϊ" + curnum);
                //�����ڴ˶���������ϵȴ��������߳�
                notifyAll();
        } 
        
        /**
         * ����ָ�������Ĳ�Ʒ
         *
         * @param neednum
         */
        public synchronized void consume(int neednum) {
                //�����Ƿ������
                while (curnum < neednum) {
                        try {
                        	System.out.println(System.nanoTime()+"---"+Thread.currentThread().getName()+"----consume����---"+"curnum:"+curnum +"__"+"neednum:"+neednum);
                                //��ǰ�������̵߳ȴ�
                                wait();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
                //����������������������ѣ�����򵥵ĸ��ĵ�ǰ�����
                curnum -= neednum;
                System.out.println(System.nanoTime()+"---"+Thread.currentThread().getName()+"----�Ѿ�������" + neednum +"����Ʒ���ֲִ���Ϊ" + curnum);
                //�����ڴ˶���������ϵȴ��������߳�
                notifyAll();
        }
} 
