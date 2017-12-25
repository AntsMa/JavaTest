package com.thread.FutureTask;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shichen.ma on 2017/11/2.
 */
public class ConnectionPool {
    private Map<String, Connection> connectionPool = new HashMap<String, Connection>();
    private ReentrantLock lock = new ReentrantLock();

    public Connection getConnection(String key){
        try{
            lock.lock();
            if(connectionPool.containsKey(key)){
                return connectionPool.get(key);
            }
            else{
                //创建 Connection
                Connection conn = createConnection();
                connectionPool.put(key, conn);
                return conn;
            }
        }
        finally{
            lock.unlock();
        }
    }

    //创建Connection
    private Connection createConnection(){
        return null;
    }



}
