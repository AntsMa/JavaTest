package com.thread.demo2;


/**
* 消费者
*/
public class Consumer extends Thread{
	private int neednum;                //生产产品的数量
    private Godown godown;            //仓库

    Consumer(String name,int neednum, Godown godown) {
    		super(name);
            this.neednum = neednum;
            this.godown = godown;
    } 
    
    public void run() {
            //消费指定数量的产品
            godown.consume(neednum);
    }
}
