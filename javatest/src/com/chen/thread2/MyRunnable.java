package com.chen.thread2;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: MyRunnable.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月27日 下午1:26:04 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class MyRunnable implements Runnable{
	 private Foo foo =new Foo();

	    public static void main(String[] args) {
	        MyRunnable r = new MyRunnable();
	        Thread ta = new Thread(r,"Thread-A");
	        Thread tb = new Thread(r,"Thread-B");
	        ta.start();
	        tb.start();

	    }

	    public void run() {
	        for (int i = 0; i < 3; i++) {
	            this.fix(30);
	            try {
	                Thread.sleep(1);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println(Thread.currentThread().getName() + " :当前foo对象的x值= " + foo.getX());
	        }
	    }

	    public int fix(int y) {
	        return foo.fix(y);
	    } 
}
