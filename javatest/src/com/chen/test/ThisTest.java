package com.chen.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**  
 * Copyright: Copyright (c) 2015 Asiainfo
 * 
 * @ClassName: ThisTest.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2015年12月30日 上午11:23:38 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class ThisTest {

	public static void main(String[] args) throws ParseException {
		Student st = new Student();
		String[] aa = {"1","2","3"};
//		st.setConditionType(aa);
		
		 Timestamp  ts=new Timestamp(new Date().getTime());
		 System.out.println(aa);
		 DateFormat dfm =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Timestamp tm = new Timestamp(dfm.parse("2015-12-12 12:22:11").getTime());
		 System.out.println(tm);
	}

}
