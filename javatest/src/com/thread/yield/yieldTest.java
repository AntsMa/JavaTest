package com.thread.yield;
/**
* Java线程：线程的调度-让步
*
* @author leizhimin 2009-11-4 9:02:40
*/
public class yieldTest {
        public static void main(String[] args) {
                Thread t1 = new MyThread1();
                Thread t2 = new Thread(new MyRunnable());
                MyRunnable2 t3 = new MyRunnable2();
                t2.start();

                t3.run();
                t1.start();
           /*    Thread t11 = new MyThread1();
                Thread t12 = new MyThread1();
                t11.start();
                t12.start();*/

              /*  //不继承线程使用的方法
                NotThread2 tl21 = new NotThread2("t1");
                NotThread2 tl22 = new NotThread2("t2");
                NotThread2 tl23 = new NotThread2("t3");

                tl21.run();
                tl22.run();
                tl23.run();*/

//                Thread t21 = new Thread(new MyRunnable());
//                Thread t22 = new Thread(new MyRunnable());
//                t21.start();
//                t22.start();

           /*     RubbableTicket runTicket = new RubbableTicket();
                new Thread(runTicket).start();
                new Thread(runTicket).start();
                new Thread(runTicket).start();*/
        }
}

class MyThread1 extends Thread {
        public void run() {
                for (int i = 0; i < 10; i++) {
                        System.out.println("线程1第" + i + "次执行！");
                }
        }
}

class NotThread2  {
        private String name;
        public NotThread2(String name){
                this.name = name;
        }
        public void run() {
                for (int i = 0; i < 10; i++) {
                        System.out.println("线程"+ this.name +"第" + i + "次执行！");
                }
        }
}
class MyRunnable implements Runnable {
        public void run() {
                for (int i = 0; i < 10; i++) {
                        System.out.println("线程2第" + i + "次执行！");
                        Thread.yield();
                }
        }
}

class MyRunnable2 implements Runnable {
        public void run() {
                for (int i = 0; i < 10; i++) {
                        System.out.println("线程3第" + i + "次执行！");
//                        Thread.yield();
                }
        }
}

class RubbableTicket implements Runnable{
        private int ticket=10;
        public void run(){
                for(int i=0;i<20;i++){
                        if(this.ticket>0){
                                System.out.println("卖票：ticket"+this.ticket--);
                        }
                }
        }
}