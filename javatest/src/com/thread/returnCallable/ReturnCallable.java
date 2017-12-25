package com.thread.returnCallable;
import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;/**
* Java线程：有返回值的线程
*
* @author Administrator 2009-11-5 0:41:50
*/
public class ReturnCallable {
        public static void main(String[] args)throws ExecutionException, InterruptedException {
                //创建一个线程池
                ExecutorService pool = Executors.newFixedThreadPool(2);

                //创建两个有返回值的任务
                Callable c1 = new MyCallable("A");
                Callable c2 = new MyCallable("B");
                //执行任务并获取Future对象
                Future f1 = pool.submit(c1);
                Future f2 = pool.submit(c2);
                //从Future对象上获取任务的返回值，并输出到控制台
                System.out.println(">>>"+f1.get().toString());
                System.out.println(">>>"+f2.get().toString());
                //关闭线程池
                pool.shutdown();


                ExecutorService threadService = Executors.newFixedThreadPool(3);
                Callable cl1 = new CallableTest("AA");
                Callable cl2 = new CallableTest("bb");
                Callable cl3 = new CallableTest("cc");
                Callable cl4 = new CallableTest("dd");

                Future ft1 = threadService.submit(cl1);
                Future ft2 = threadService.submit(cl2);
                Future ft3 = threadService.submit(cl3);
                Future ft4 = threadService.submit(cl4);



                System.out.println(ft1.get().toString());
                System.out.println(ft2.get().toString());
                System.out.println(ft3.get().toString());
                System.out.println(ft4.get().toString());
                threadService.shutdown();


        }
} 
class MyCallable implements Callable{
        private String oid;

        MyCallable(String oid) {

                this.oid = oid;
        }

        @Override

        public Object call()throws Exception {
                return oid+"任务返回的内容";
        }
}


class CallableTest implements Callable{
        private String name ;
        CallableTest(String call){
                this.name = call;
        }

        @Override
        public Object call() throws Exception {
                return this.name +" call 执行";
        }
}