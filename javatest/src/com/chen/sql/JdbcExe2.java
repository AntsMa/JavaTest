package com.chen.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

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
public class JdbcExe2 {
	 static String driver = "com.mysql.jdbc.Driver";
     static String dbName = "test";
     static String pwd = "root";
     static String userName = "root";
     static String url = "Jdbc:mysql://localhost:3306/" + dbName;
	public static void main(String[] args) throws SQLException {
		Jdbc jdbc = new Jdbc();
		jdbc.jdbcComm(driver, dbName, userName, pwd, url);
		String sqlQuery = "select * from student";
		ResultSet rs = jdbc.query(sqlQuery);
		while(rs.next()){
			  System.out.println("id : " + rs.getInt(1) + " name : "
                      + rs.getString(2) + " password : " + rs.getString(3));
		}
		System.out.println("\n");
		jdbc.close(rs, jdbc.ps, jdbc.conn);
		jdbc.jdbcComm(driver, dbName, userName, pwd, url);
		String sqlUpdate = "INSERT INTO student (NAME, PASSWORD) VALUES('test1', 'test1') ";
		int resultInt = jdbc.update(sqlUpdate);
		System.out.println("resultInt : "+resultInt);
		System.out.println("\r\n");
		rs = jdbc.query(sqlQuery);
		while(rs.next()){
			  System.out.println("id : " + rs.getInt(1) + " name : "
                      + rs.getString(2) + " password : " + rs.getString(3));
		}
		
		jdbc.close(rs, jdbc.ps, jdbc.conn);
		
	}

}
