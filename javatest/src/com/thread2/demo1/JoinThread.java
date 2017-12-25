package com.thread2.demo1;

/**
 * Created by shichen.ma on 2017/8/22.
 */
public class JoinThread extends Thread {

        public static int i = 0;

        //public static AtomicInteger atomicInteger = new AtomicInteger(0);

        public synchronized void inc(){
            i ++;
        }
        @Override
        public void run() {
            for (int x = 0; x < 10; x++) {
                inc();
                try {
                    Thread.sleep(33);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            // TODO Auto-generated method stub
            JoinThread jt = new JoinThread();
            Thread[] t = new Thread[100];
            for (int i = 0; i < t.length; i++) {
                t[i] = new Thread(jt);
            }
           /*  JoinThread jt = new JoinThread();
            Thread[] t = new Thread[100];
            for (int i = 0; i < t.length; i++) {
                t[i] = new JoinThread();
            }*/
            for (int i = 0; i < t.length; i++) {
                t[i].start();
            }
            for (int i = 0; i < t.length; i++) {
                t[i].join();
            }
            System.out.println(JoinThread.i);
        }

    }
