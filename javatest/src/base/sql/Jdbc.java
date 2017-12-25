package base.sql;

import java.sql.*;

/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: jdbc.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月18日 下午1:57:46 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class Jdbc {
	Connection conn;
	PreparedStatement ps ;
	public void jdbcComm(String driver,String dbName,String userName,String pwd,String url){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String sql) throws SQLException{
		ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}
	
	public int update(String sql,Boolean commitFlag) throws SQLException{
		conn.setAutoCommit(false);
		ps = conn.prepareStatement(sql);
		if(commitFlag)
		{
			conn.commit();
			System.out.println("----------");
		}
		return ps.executeUpdate(sql);
	}
	
	public void close(ResultSet rs,PreparedStatement ps,Connection conn){
		 // 关闭记录集
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 关闭声明
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 关闭链接对象
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
