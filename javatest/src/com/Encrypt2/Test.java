package com.Encrypt2;

import com.ai.security.impl.DefaultHashEncrypt;

/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Test.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年4月27日 上午9:48:30 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class Test {
	public static void main(String[] args) throws Exception {
		//加密：
		DefaultHashEncrypt defaultHashEncrypt = new DefaultHashEncrypt();
		String salt = defaultHashEncrypt.getSalt();//生成盐
		String plain = "112358";
		salt = "11";
		String ciphertext= defaultHashEncrypt.encrypt(plain, salt);//hash加密之后生成密文ciphertext
		//salt和ciphertext入库
		
		EncryptUtil md5 =new EncryptUtil();
		String md5pwd =  md5.encrypt(plain, salt);
		
		System.out.println(md5pwd);
		System.out.println(ciphertext);
		//验证：
		//从数据库里取出salt
	//	String ciphertext2= defaultHashEncrypt.encrypt(plain, salt);
		//验证ciphertext和ciphertext2是否相等。

		//附近中是提供给66x版本使用的aisecurity的包
	}
}
