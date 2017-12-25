package com.Encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Encrypt.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年4月26日 上午10:28:41 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class Encrypt {
	
	
	
	/** 
	   * 传入文本内容，返回 SHA-256 串 
	   *  
	   * @param strText 
	   * @return 
	   */  
	public static String SHA256(final String strText){
		return SHA(strText,"SHA-256");
	}
	
	private static String SHA(final String strText,final String strType){
		//返回值
		String strResult =null;
		
		//是否是有效字符串
		if(null != strText  && strText.length() > 0){
			try
			{
				//sha 加密开始
				//创建加密对象 并且传入加密类型
				MessageDigest msgDigest = MessageDigest.getInstance(strType);
				
				//传入要加密的字符串
				msgDigest.update(strText.getBytes());
				
				//得到byte类型结果
				byte byteBuffer[] = msgDigest.digest();
				
				//将byte转换为String
				StringBuffer strHexString = new StringBuffer();
				
				//遍历byte buffer
				for (int i = 0; i < byteBuffer.length; i++) {
					String hex = Integer.toHexString(0xff & byteBuffer[i]);
					
					if(hex.length() == 1)
					{
						strHexString.append('0');
					}
					strHexString.append(hex);
					
				}
				//得到返回结果
				strResult = strHexString.toString();
			}
			catch(NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
	}
		return strResult;
	}
	
	public static void main(String[] args) {
		SHA256("1");
	}
}
