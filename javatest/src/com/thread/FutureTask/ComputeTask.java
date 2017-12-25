package com.thread.FutureTask;

import java.util.concurrent.Callable;

public class ComputeTask implements Callable<Integer> {

    private Integer result = 0;
    private String taskName = "";

    public ComputeTask(Integer iniResult, String taskName){
        result = iniResult;
        this.taskName = taskName;
        System.out.println("生成子线程计算任务: "+taskName);
    }

    public String getTaskName(){
        return this.taskName;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 100; i++) {
            result =+ i;
        }
        // 休眠5秒钟，观察主线程行为，预期的结果是主线程会继续执行，到要取得FutureTask的结果是等待直至完成。
        Thread.sleep(5000);
        System.out.println("子线程计算任务: "+taskName+" 执行完成!");
        return result;
    }
}
