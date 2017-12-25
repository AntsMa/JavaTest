package com;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: test.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年5月26日 上午10:06:37 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class test {

	public static void main(String[] args) {

		String  toRemoveBefore="F:/AsiaInfo/Hungary/log/cur/CA_INV_INFO_22_20160624.csv";
		String name ="F:/AsiaInfo/Hungary/log/cur/CA_INV_INFO_22_2016062416.csv";
		String fileNameOrig = "F:/AsiaInfo/Hungary/log/cur/CA_INV_INFO_22_";
		System.out.println(name.startsWith(fileNameOrig));
		System.out.println(name.compareTo(toRemoveBefore));
		
		String sp = "\r";
		StringBuffer sb = new StringBuffer();
		sb.append(sp).append("qqq").append(sp).append("111");
		System.out.println(sb.toString());
		System.out.println("222\r333\rppps\r1111");
		System.out.println("222\000333\000ppps\0001111");
		System.out.println("\t222\t333\tppps\t1111".toString().trim());
		System.out.println("222\t333\tppps\t1111");

	}

}
