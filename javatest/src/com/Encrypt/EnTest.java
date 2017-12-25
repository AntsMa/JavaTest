package com.Encrypt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.chen.sql.*;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: JdbcExe.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月18日 下午2:10:41 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class EnTest {
	 static String driver = "com.mysql.jdbc.Driver";
     static String dbName = "test";
     static String pwd = "root";
     static String userName = "root";
     static String url = "Jdbc:mysql://10.11.18.104:3306/" + dbName;
 	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
 	
 	public static void main(String[] args) throws SQLException {
		Jdbc jdbc = new Jdbc();
		jdbc.jdbcComm(driver, dbName, userName, pwd, url);
		
		Encrypt en = new Encrypt();
		String pwd = "112358";
		
		String name ="masc";
		for(int i =0;i<pwd.length();i++)
		{
			getSalt(name);
		}
		String pwdSalt = new StringBuffer(pwd).reverse().toString()+pwd.length()+getSalt(name);
		
		pwd = en.SHA256(pwdSalt);
		
		//插入
		String sqlInsert = "INSERT INTO login (username, pwd) VALUES('"+name+"', '"+pwd+"') ";
		insert(jdbc, sqlInsert);
		
		//更新
		String sqlUpdate = "update login set username ='masc' ,pwd = '"+pwd+"'";

		//查询
		String sqlQuery = "select * from login";
	}
	
	public static String getSalt(String name){
		String salt =  generateString(name.length());
		return salt;
	}
	
	public static void insert(Jdbc jdbc,String sqlInsert) throws SQLException{
		//插入
		int resultInt = jdbc.update(sqlInsert);
		System.out.println("resultInt : "+resultInt);
		System.out.println("\r\n");
		jdbc.close(null, jdbc.ps, jdbc.conn);
	}
	
	public static void query(Jdbc jdbc,String sqlQuery) throws SQLException{
		ResultSet rs = jdbc.query(sqlQuery);
		while(rs.next()){
			  System.out.println("name : " + rs.getInt(1) + " pwd : "
                      + rs.getString(2) + " loginid : " + rs.getString(3));
		}
		System.out.println("\n");
		jdbc.close(rs, jdbc.ps, jdbc.conn);
	}
	
	public static void update(Jdbc jdbc,String sqlQuery) throws SQLException{
		//插入
		jdbc.jdbcComm(driver, dbName, userName, pwd, url);
		String sqlUpdate = "INSERT INTO student (NAME, PASSWORD) VALUES('test1', 'test1') ";
		int resultInt = jdbc.update(sqlUpdate);
		System.out.println("resultInt : "+resultInt);
		System.out.println("\r\n");
		jdbc.close(null, jdbc.ps, jdbc.conn);
	}
	
	public static String generateString(int length) {

		StringBuffer sb = new StringBuffer();

		Random random = new Random();

		for (int i = 0; i < length; i++) {

			sb.append(allChar.charAt(random.nextInt(allChar.length())));

		}

		return sb.toString();

	}
	

}
