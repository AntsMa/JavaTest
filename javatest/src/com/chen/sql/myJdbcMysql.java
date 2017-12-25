package com.chen.sql;

import java.sql.*;
import java.util.Collection;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.05.05 15:30
 */
public class myJdbcMysql {


    public static void main(String[] args){
        String driver = "com.mysql.jdbc.Driver";
        String user ="root";
        String password = "root";
        String bdName = "test";
        String url = "jdbc:mysql://10.11.18.156:3306/"+bdName;
        String sql = "select * from student";

        try {
            Class.forName(driver);
            Connection collection =  DriverManager.getConnection(url,user,password);
            PreparedStatement ps = collection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("id:"+rs.getInt(1)+",name:"+rs.getString(2)+",age:"+rs.getString(3));
            }

            if(rs != null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(ps != null ){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(collection != null ){
                try {
                    collection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

