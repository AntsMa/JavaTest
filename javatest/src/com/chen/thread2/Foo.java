package com.chen.thread2;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Foo.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月27日 下午1:25:16 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class Foo {
	private int x = 100;

    public int getX() {
        return x;
    }

   /* public int fix(int y) {
        x = x - y;
        return x;
    }*/ 
    
    public int fix(int y){
    	synchronized(this){
    		x = x -y;
    	}
    	return x;
    }
}
