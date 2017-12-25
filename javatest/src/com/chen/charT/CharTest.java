package com.chen.charT;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: CharTest.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年2月2日 上午11:13:55 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class CharTest {

	public static void main(String[] args) {

		String strLine = addLine("AaaDddJaf");
		System.out.println(strLine);
	}
	
	 static String addLine(String str){
		 if(null == str)
		 {
			 return null;
		 }
		 char[] charArr = str.toCharArray();
		 StringBuffer sb = new StringBuffer();
		 for(int i=0;i<charArr.length;i++)
		 {
			 if(Character.isUpperCase(charArr[i]) && i != 0)
			 {
				 sb.append("_");
			 }
			 sb.append(charArr[i]);
		 }
		return sb.toString();
	}

}

