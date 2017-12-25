package com.Encrypt2;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 
 * @author terry
 *
 */
public class EncryptUtil {

	/**
	 * 
	* <p>Title: encrypt</p>
	* <p>Description: 将传进来密码加密方法</p>
	* @param data
	* @param salt
	* @return
	 */
    public static  String encrypt(String data,String salt) {
//        return new Md5Hash(data,salt).toBase64();
    	return new Md5Hash(data,salt).toString();
    }

}
