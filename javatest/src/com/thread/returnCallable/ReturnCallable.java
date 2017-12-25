package com.thread.returnCallable;
import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;/**
* Java�̣߳��з���ֵ���߳�
*
* @author Administrator 2009-11-5 0:41:50
*/
public class ReturnCallable {
        public static void main(String[] args)throws ExecutionException, InterruptedException {
                //����һ���̳߳�
                ExecutorService pool = Executors.newFixedThreadPool(2);

                //���������з���ֵ������
                Callable c1 = new MyCallable("A");
                Callable c2 = new MyCallable("B");
                //ִ�����񲢻�ȡFuture����
                Future f1 = pool.submit(c1);
                Future f2 = pool.submit(c2);
                //��Future�����ϻ�ȡ����ķ���ֵ�������������̨
                System.out.println(">>>"+f1.get().toString());
                System.out.println(">>>"+f2.get().toString());
                //�ر��̳߳�
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
                return oid+"���񷵻ص�����";
        }
}


class CallableTest implements Callable{
        private String name ;
        CallableTest(String call){
                this.name = call;
        }

        @Override
        public Object call() throws Exception {
                return this.name +" call ִ��";
        }
}