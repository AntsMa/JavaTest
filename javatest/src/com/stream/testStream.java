package com.stream;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by shichen.ma on 2017/8/18.
 */
public class testStream {

    public static String name;
    public static void main(String[] args) {
        byte[] sim = {(byte)0xbc, (byte)0xf2, // 简
                (byte)0xcc, (byte)0xe5, // 体
                (byte)0xd6, (byte)0xd0, // 中
                (byte)0xce, (byte)0xc4}; // 文
//        OutputStream os = sim ;
//        DataOutputStream dos = new DataOutputStream(os);
//        PrintWriter pw = new PrintWriter(dos);
//        PrintStream ps = new PrintStream(dos);
    }
}
