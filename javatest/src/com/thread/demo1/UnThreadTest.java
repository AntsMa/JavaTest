package com.thread.demo1;
/**
* Java线程：线程的同步
*
* @author leizhimin 2009-11-4 11:23:32
*/
public class UnThreadTest {
        public static void main(String[] args) {
                UserInfo u = new UserInfo("张三", 100);
                MyUnThread t1 = new MyUnThread("线程A", u, 20);
                MyUnThread t2 = new MyUnThread("线程B", u, -60);
                MyUnThread t3 = new MyUnThread("线程C", u, -80);
                MyUnThread t4 = new MyUnThread("线程D", u, -30);
                MyUnThread t5 = new MyUnThread("线程E", u, 32);
                MyUnThread t6 = new MyUnThread("线程F", u, 21);

                t1.run();

                t2.run();
                t3.run();
                t4.run();
                t5.run();
                t6.run();
        }
}

class MyUnThread {
        private UserInfo u;
        private int y = 0;

        MyUnThread(String name, UserInfo u,int y) {
//                super(name);
                this.u = u;
                this.y = y;
        } 
        
        public void run() {
                u.oper(y);
        }
}

class UserInfo {
        private String code;
        private int cash;

        UserInfo(String code,int cash) {
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
        public void oper(int x) {
                try {
                        Thread.sleep(100L);
//                        this.cash += x;
//                        System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x +"”，当前用户账户余额为：" + cash);
			            System.out.println(System.nanoTime() +"---"+ Thread.currentThread().getName() +",cash:"+this.cash);
			            System.out.println( System.nanoTime() +"---" +Thread.currentThread().getName()+",cash:"+this.cash+",x:"+x+","+(this.cash = this.cash+ x)); 
			            System.out.println(System.nanoTime() + "---"+Thread.currentThread().getName() +","+ ",运行结束，增加“" + x +"”，当前用户账户余额为：" + cash);
                        Thread.sleep(100L);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }

        @Override

        public String toString() {
                return"UserInfo{" +
                                "code='" + code + '\'' +
                                ", cash=" + cash +
                                '}';
        }
}