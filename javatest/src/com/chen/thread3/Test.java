package com.chen.thread3;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Test.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月27日 下午2:30:34 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class Test {
	   public static void main(String[] args) {
	        final NameList nl =new NameList();
	        nl.add("aaa");
		   nl.add("bbb");
		   nl.add("ccc");
	        class NameDropper extends Thread{
	            public void run(){
	                String name = nl.removeFirst();
	                System.out.println("remove_name:"+name);
	            }
	        }

	        Thread t1 = new NameDropper();
	        Thread t2 = new NameDropper();
	        t1.start();
	        t2.start();
	    } 
}
