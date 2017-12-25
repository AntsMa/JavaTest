package com.thread.Deadlock;

public class DeadLockTest2 implements Runnable{
    private int flag;
    static Object o1 = new Object(), o2 = new Object();      //静态的对象，被DeadLockTest的所有实例对象所公用

    public void run(){

        System.out.println(flag);
        if(flag == 0){
            synchronized(o1){
                try{
                    Thread.sleep(500);
                    System.out.println("o1"+"_flag = 0");
                } catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(o2){
                    System.out.println("o2"+"_flag = 0");
                }
            }
        }
        if(flag == 1){
            synchronized(o2){
                try{
                    Thread.sleep(500);
                    System.out.println("o2"+"_flag = 1");
                } catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(o1){
                    System.out.println("o1"+"_flag = 1");
                }
            }
        }
    }

    public static void main(String[] args){
        DeadLockTest2 test1 = new DeadLockTest2();
        DeadLockTest2 test2 = new DeadLockTest2();
        test1.flag = 1;
        test2.flag = 0;
        Thread thread1 = new Thread(test1);
        Thread thread2 = new Thread(test2);
        thread1.start();
        thread2.start();
    }
}