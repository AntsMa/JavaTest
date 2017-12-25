package com.thread.demo1;
/**
* Java线程：线程的同步
*
* @author leizhimin 2009-11-4 11:23:32
*/
public class SynchronizedTest {
        public static void main(String[] args) {
             /*   User u = new User("张三", 100);
                MyThread t1 = new MyThread("线程A", u, 20);
                MyThread t2 = new MyThread("线程B", u, -60);
                MyThread t3 = new MyThread("线程C", u, -80);
                MyThread t4 = new MyThread("线程D", u, -30);
                MyThread t5 = new MyThread("线程E", u, 32);
                MyThread t6 = new MyThread("线程F", u, 21);

                t1.start();

                t2.start();
                t3.start();
                t4.start();
                t5.start();
                t6.start();*/
                Principle p = new Principle("principle");
                p.memo("priciple");
                p.memo("dependency");
                Principle p1 = new Principle("principle");
                p1.memo("treated");

        }
}

class MyThread extends Thread {
        private User u;
        private int y = 0;

        MyThread(String name, User u,int y) {
                super(name);
                this.u = u;
                this.y = y;
        } 
        
        public void run() {
                u.oper(y);
        }
}

class User {
        private String code;
        private int cash;

        User(String code,int cash) {
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
        public synchronized void oper(int x) {
                try {
                        Thread.sleep(10L);
//                        this.cash += x;
//                        System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x +"”，当前用户账户余额为：" + cash);
                        System.out.println(System.nanoTime() +"---"+ Thread.currentThread().getName() +",cash:"+this.cash);
			            System.out.println( System.nanoTime() +"---" +Thread.currentThread().getName()+",cash:"+this.cash+",x:"+x+","+(this.cash = this.cash+ x)); 
			            System.out.println(System.nanoTime() + "---"+Thread.currentThread().getName() +","+ ",运行结束，增加“" + x +"”，当前用户账户余额为：" + cash);
                        Thread.sleep(10L);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }

        @Override

        public String toString() {
                return"User{" +
                                "code='" + code + '\'' +
                                ", cash=" + cash +
                                '}';
        }
}


class Principle{
        private  String name ;
        public Principle(String name ){
                this.name = name;
        }
        public void memo(String name ){
                for(int i = 0 ; i<1000;i++){
                        System.out.println("name"+i+name);
                }
        }
}