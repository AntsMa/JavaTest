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
public class RunnableTest implements Runnable{

	private String name;
	
	public RunnableTest(String name){
		this.name = name;
	}
	@Override
	public void run() {

		for(int i=0;i<5;i++)
		{
			for(long k=0;k <3;k++)
			{
				if(i==2)
				{
					 try {
				            Thread.sleep(10000);
				        } catch (InterruptedException e) {
				            e.printStackTrace(); 
				        }
				}
				System.out.println(name + ":" + i+"_"+k);
			}
		}
	}
	
}
