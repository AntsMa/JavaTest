package com.thread.wait;
/**
* ������������߳������������
*
* @author leizhimin 2008-9-15 13:20:38
*/
public class ThreadA {
    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
//        ThreadC c = new ThreadC();
//        c.start();

        b.start();

      /*  System.out.println("�ȴ�����b��ɼ��㡣����");
        synchronized(b){
            b.wait();
        }
        System.out.println("b���������ܺ��ǣ�" + b.total);*/

        //���������߳�
        //�߳�Aӵ��b�����ϵ������߳�Ϊ�˵���wait()��notify()���������̱߳������Ǹ���������ӵ����
       synchronized (b) {
            try {
                System.out.println("�ȴ�����b��ɼ��㡣����");
//                System.out.println("�ȴ�����c��ɼ��㡣����");
//                ��ǰ�߳�A�ȴ�
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("C���������ܺ��ǣ�" + b.total);
            System.out.println("b���������ܺ��ǣ�" + b.total);
        }


    }
}