package com.thread.FutureTask;

import java.sql.Connection;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * Created by shichen.ma on 2017/11/2.
 */
public class ConnectionPool2 {
    private ConcurrentHashMap<String,FutureTask<Connection>> connectionPool = new ConcurrentHashMap<String, FutureTask<Connection>>();

    public Connection getConnection(String key) throws Exception{
        FutureTask<Connection>connectionTask = connectionPool.get(key);
        if(connectionTask!=null){
            return connectionTask.get();
        }
        else{
            Callable<Connection> callable = new Callable<Connection>(){
                public Connection call() throws Exception {
                    return createConnection();
                }
            };
            FutureTask<Connection>  newTask = new FutureTask<Connection>(callable);
            connectionTask = connectionPool.putIfAbsent(key, newTask);
            if(connectionTask==null){
                connectionTask = newTask;
                connectionTask.run();
            }
            return connectionTask.get();
        }
    }

    //´´½¨Connection
    private Connection createConnection(){
        return null;
    }
}
