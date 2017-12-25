package com.chen.time;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: timeFormat.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月19日 下午8:37:29 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class timeFormat {
	public static void main(String[] args) throws ParseException {
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp timestamp = new Timestamp(format.parse("2016-01-02").getTime());
		Timestamp timestamp2 = new Timestamp(format.parse("2016-03-02").getTime());
		
		String fromMonth = timestamp.toString().substring(5,7);
		String toMonth = timestamp2.toString().substring(5,7);
		System.out.println(format+""+toMonth);
	}
}
