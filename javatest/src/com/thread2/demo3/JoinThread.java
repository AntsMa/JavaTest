package com.thread2.demo3;

public class JoinThread extends Thread {

    public static int i = 0;

    //public static AtomicInteger atomicInteger = new AtomicInteger(0);

    //1
    public synchronized  void inc(){
        i ++;
    }

    //2
   /* public synchronized static void inc(){
        i ++;
    }*/
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
        //3   31 ,32
     /*   Thread[] t = new Thread[100];
        for (int i = 0; i < t.length; i++) {
            t[i] = new JoinThread();
        }*/
        JoinThread jt = new JoinThread();
        Thread[] t = new Thread[100];
        // 4    41 ,42
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(jt);
        }

        for (int i = 0; i < t.length; i++) {
            t[i].start();
        }
        for (int i = 0; i < t.length; i++) {
            t[i].join();
        }
        System.out.println(JoinThread.i);
    }

}