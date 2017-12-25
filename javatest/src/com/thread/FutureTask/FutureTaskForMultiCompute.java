package com.thread.FutureTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by shichen.ma on 2017/11/2.
 */
public class FutureTaskForMultiCompute {
    public static void main(String[] args) {

        // �������񼯺�
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();
        // �����̳߳�
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // ����Callable���󴴽�FutureTask����
            FutureTask<Integer> ft = new FutureTask<Integer>(new ComputeTask(i, "" + i));
            taskList.add(ft);
            // �ύ���̳߳�ִ������Ҳ����ͨ��exec.invokeAll(taskList)һ�����ύ��������;
            exec.submit(ft);
        }

        System.out.println("���м��������ύ���, ���߳̽��Ÿ��������飡");

        // ��ʼͳ�Ƹ������̼߳�����
        Integer totalResult = 0;
        for (FutureTask<Integer> ft : taskList) {
            try {
                //FutureTask��get�������Զ�����,ֱ����ȡ������Ϊֹ
                totalResult = totalResult + ft.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // �ر��̳߳�
        exec.shutdown();
        System.out.println("������������ܽ����:" + totalResult);
    }
}
