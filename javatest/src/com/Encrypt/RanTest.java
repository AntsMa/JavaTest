package com.Encrypt;

import java.util.Random;

import org.omg.IOP.Encoding;

/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: test.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年4月26日 下午3:19:09 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class RanTest {
	/*
	 * 	1、通过System.currentTimeMillis()来获取一个当前时间毫秒数的long型数字。
　　		2、通过Math.random()返回一个0到1之间的double值。
　　		3、通过Random类来产生一个随机数，这个是专业的Random工具类，功能强大。
	 */
	public static int ranT1(){
		//(数据类型)(最小值+Math.random()*(最大值-最小值+1))
		return (int)(1+Math.random()*(10-1+1));
	}
	
	public static int ran2(){
		for (int i=0;i<30;i++)
		{System.out.println((int)(1+Math.random()*10));}
		return (int)(1+Math.random()*10);
	}
	
	public static void ran3(){
		Random ra =new Random();
		for (int i=0;i<30;i++)
		{
			System.out.println(ra.nextInt(10)+1);
			System.out.println(ra.nextInt(10));
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(ran2());
		ran3();
	}
}
