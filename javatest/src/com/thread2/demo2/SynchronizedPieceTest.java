package com.thread2.demo2;

/**
 * Java线程：线程的同步
 *
 * @author leizhimin 2009-11-4 11:23:32
 */
public class SynchronizedPieceTest {
    public static void main(String[] args) {
        User3 u = new User3("张三", 300);
     /*   u.oper(2);

        User3 u1 = new User3("张三", 100);
        u1.oper(3);
        u.oper(2);
        u1.oper(3);
        u.oper(2);*/

             /*   MyThread3 t1 = new MyThread3("线程A", u, 20);
                MyThread3 t2 = new MyThread3("线程B", u, -60);
                MyThread3 t3 = new MyThread3("线程C", u, -80);
                MyThread3 t4 = new MyThread3("线程D", u, -30);
                MyThread3 t5 = new MyThread3("线程E", u, 32);
                MyThread3 t6 = new MyThread3("线程F", u, 21);*/

        MyThread3 t1 = new MyThread3("线程2", u, 20);
        MyThread3 t2 = new MyThread3("线程3", u, 30);
        MyThread3 t3 = new MyThread3("线程6", u, 60);
        MyThread3 t4 = new MyThread3("线程7", u, 70);
        MyThread3 t5 = new MyThread3("线程8", u, 80);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
//                t6.start();
    }
}

class MyThread3 extends Thread {
    private User3 u;
    private int y = 0;

    MyThread3(String name, User3 u,int y) {
        super(name);
        this.u = u;
        this.y = y;
    }

    public void run() {
        u.oper(y);
    }
}

class User3 {
    private String code;
    private int cash;

    User3(String code,int cash) {
        this.code = code;
        this.cash = cash;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    /**
     * 业务方法
     * @param x 添加x万元
     */
    public  void oper(int x) {
        try {
            Thread.sleep(10L);
//            System.out.println(Thread.currentThread().getName() + "运行开始，增加“" + x +"”，当前用户账户余额为：" + this.cash + ",cash:"+cash);
//            this.cash += x;
//            System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x +"”，当前用户账户余额为：" + this.cash + ",cash:"+cash);
            synchronized(this){
                System.out.println(System.nanoTime() +"---"+ Thread.currentThread().getName() +",cash:"+this.cash);
                System.out.println( System.nanoTime() +"---" +Thread.currentThread().getName()+",cash:"+this.cash+",x:"+x+","+(this.cash = this.cash+ x));
                System.out.println(System.nanoTime() + "---"+Thread.currentThread().getName() +","+ ",运行结束，增加“" + x +"”，当前用户账户余额为：" + cash);
            }
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return"User3{" +
                "code='" + code + '\'' +
                ", cash=" + cash +
                '}';
    }
}