package com.chen.thread;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: main.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月26日 下午8:52:41 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class RunnableMain {
	public static void main(String[] args) {
		RunnableTest rt1 = new RunnableTest("aa");
		RunnableTest rt2 = new RunnableTest("bb");
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2);
		t1.start();
		t2.start();
		
//		new Thread(new RunnableTest("ee")).start();
		
		Thread tt1 = new ThreadTest("cc");
		Thread tt2 = new ThreadTest("dd");
		tt1.start();
		tt2.start();
	}
}
