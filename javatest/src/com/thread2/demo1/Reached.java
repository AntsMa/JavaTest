package com.thread2.demo1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.06.12 17:10
 */
public class Reached extends  Thread {

    public static int i = 0;

    /*public synchronized void inc() {
        i++;
    }

    public void run() {
        for (int x = 0; x < 10; x++) {
            inc();
            System.out.println(new Date().getTime()+"__"+Thread.currentThread().getName() +"___"+i);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    public static String getDateTime(){
        Date nowTime=new Date();
        SimpleDateFormat time=new SimpleDateFormat("mm-ss-ms");
      return  time.format(nowTime);
    }

    public static void main(String[] args) throws InterruptedException {
        Reached reached = new Reached();
        Thread[] t = new Thread[10];
        for (int i = 0; i < t.length; i++) {
            t[i] =new Thread(reached);
        }
        for (int i = 0; i < t.length; i++) {
            t[i].start();
            t[i].setName("t"+i);
            System.out.println("启动线程t"+i);
        }
       for (int i = 0; i < t.length; i++) {
            t[i].join();
            System.out.println(getDateTime()+"__"+"加入线程j"+i);
        }
        System.out.println(new Date().getTime()+"__"+Reached.i);
        sleep(1000);
        System.out.println(new Date().getTime()+"__"+Reached.i);
    }

  /*  public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            Reached.add();
            System.out.println(Reached.i);
        }
    }

    public static void add() {
        for (int x = 0; x < 10; x++) {
            i++;
            System.out.println( Thread.currentThread().getName() +"___"+i);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/


    public void run(){
        add();
    }

    public synchronized void add(){
        for (int x = 0; x < 10; x++) {
            i++;
            System.out.println(new Date().getTime()+"__"+Thread.currentThread().getName() +"___"+i);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
