package com.thread.FutureTask;

import java.util.concurrent.Callable;

public class ComputeTask implements Callable<Integer> {

    private Integer result = 0;
    private String taskName = "";

    public ComputeTask(Integer iniResult, String taskName){
        result = iniResult;
        this.taskName = taskName;
        System.out.println("�������̼߳�������: "+taskName);
    }

    public String getTaskName(){
        return this.taskName;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 100; i++) {
            result =+ i;
        }
        // ����5���ӣ��۲����߳���Ϊ��Ԥ�ڵĽ�������̻߳����ִ�У���Ҫȡ��FutureTask�Ľ���ǵȴ�ֱ����ɡ�
        Thread.sleep(5000);
        System.out.println("���̼߳�������: "+taskName+" ִ�����!");
        return result;
    }
}
