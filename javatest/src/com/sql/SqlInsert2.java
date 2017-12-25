package com.sql;

import java.sql.SQLException;
import java.util.Random;


/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: SqlInsert.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年5月31日 下午1:50:24 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class SqlInsert2 {

	 static String driver = "com.mysql.jdbc.Driver";
     static String dbName = "test";
     static String pwd = "root";
     static String userName = "root";
     static String url = "Jdbc:mysql://localhost:3306/" + dbName;
	public static void main(String[] args) throws SQLException {
		Jdbc jdbc = new Jdbc();
		jdbc.jdbcComm(driver, dbName, userName, pwd, url);
		int userOrderId = 130000000;
		int resultInt = 0;
		boolean commitFlag=false;
		char cha[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char ch[]=new char[50];
		char cName[]=new char[5];

		for (int i = 0; i <= 1000000; i++) {
			for(int j=0;j<cName.length;j++)
			{
				int ran = (int)(1+Math.random()*10);
				cName[j]=cha[ran];
			}
			for(int j=0;j<ch.length;j++)
			{
				int ran = (int)(1+Math.random()*10);
				ch[j]=cha[ran];
			}
			int age = new Random().nextInt(2);
			String raN = new String(cName);
			if(i%100==0){raN = "testname";}
			String name = raN;
			String ra = "iop";
			if(i%20==0){ra = "jkl";}
			String address =new String(ch)+ra;
			String sqlUpdate = "INSERT INTO student_2 (NAME,sex,address) VALUES ('"+name+"',"+age+",'"+address+"')";
			if(i%50000==0)
			{
				commitFlag = true;
			}else{
				commitFlag = false;
			}
			resultInt = jdbc.update(sqlUpdate,commitFlag);
		}
		System.out.println("resultInt : "+resultInt);
		
	}

}
