package com.thread.dead;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: DeadlockRisk.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月27日 下午3:10:52 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class DeadlockRisk {
	 private static class Resource {
	        public int value;
	    }

	    private Resource resourceA =new Resource();
	    private Resource resourceB =new Resource();

	    public int read() {
	        synchronized (resourceA) {
	            synchronized (resourceB) {
	                return resourceB.value + resourceA.value;
	            }
	        }
	    }

	    public void write(int a,int b) {
	        synchronized (resourceB) {
	            synchronized (resourceA) {
	                resourceA.value = a;
	                resourceB.value = b;
	            }
	        }
	    } 
}
