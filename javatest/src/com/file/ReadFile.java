package com.file;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: ReadFile.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年7月7日 上午11:43:00 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class ReadFile {

	public static void main(String[] args) {
		ReadFile.readFileByLines("C:\\Users\\shichen.ma\\Desktop\\temp\\ssk.txt");
	}
	 public static void readFileByBytes(String fileName) {
	        File file = new File(fileName);
	        InputStream in = null;
	      /*  try {
	            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
	            // 一次读一个字节
	            in = new FileInputStream(file);
	            int tempbyte;
	            while ((tempbyte = in.read()) != -1) {
	                System.out.write(tempbyte);
	            }
	            in.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return;
	        }*/
	        try {
	            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
	            // 一次读多个字节
	            byte[] tempbytes = new byte[100];
	            int byteread = 0;
	            in = new FileInputStream(fileName);
	            ReadFile.showAvailableBytes(in);
	            // 读入多个字节到字节数组中，byteread为一次读入的字节数
	            while ((byteread = in.read(tempbytes)) != -1) {
	                System.out.write(tempbytes, 0, byteread);
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        } finally {
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	    }
	 
	 /**
	     * 以行为单位读取文件，常用于读面向行的格式化文件
	     */
	    public static void readFileByLines(String fileName) {
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        try {
	            System.out.println("以行为单位读取文件内容，一次读一整行：");
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int line = 1;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	                System.out.println("line " + line + ": " + tempString);
	                String[] ss =tempString.split("\t");
	                for (String string : ss) {
						System.out.println(string);
					}
	                line++;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	    }

	 
	 /**
	     * 显示输入流中还剩的字节数
	     */
	    private static void showAvailableBytes(InputStream in) {
	        try {
	            System.out.println("当前字节输入流中的字节数为:" + in.available());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
