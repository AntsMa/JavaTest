package com.chen.thread;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: RunnableTest.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月26日 下午8:49:37 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class ThreadTest extends Thread{

	private String name;
	
	public ThreadTest(String name){
		this.name = name;
	}
	@Override
	public void run() {

		for(int i=0;i<5;i++)
		{
			for(long k=0;k <3;k++)
			{
				System.out.println(name + ":" + i+"_"+k+"_"+Thread.currentThread());
			}
		}
	}
	
}
