package com.thread.demo2;


/**
* 生产者
*/
public class Producer extends Thread {
        private int neednum;                //生产产品的数量
        private Godown godown;            //仓库

        Producer(String name,int neednum, Godown godown) {
        		super(name);
                this.neednum = neednum;
                this.godown = godown;
        } 
        public void run() {
                //生产指定数量的产品
                godown.produce(neednum);
        }
} 