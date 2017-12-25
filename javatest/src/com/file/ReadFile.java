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
 * @Description: ����Ĺ�������
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016��7��7�� ����11:43:00 
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
	            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
	            // һ�ζ�һ���ֽ�
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
	            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");
	            // һ�ζ�����ֽ�
	            byte[] tempbytes = new byte[100];
	            int byteread = 0;
	            in = new FileInputStream(fileName);
	            ReadFile.showAvailableBytes(in);
	            // �������ֽڵ��ֽ������У�bytereadΪһ�ζ�����ֽ���
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
	     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ�
	     */
	    public static void readFileByLines(String fileName) {
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        try {
	            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int line = 1;
	            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
	            while ((tempString = reader.readLine()) != null) {
	                // ��ʾ�к�
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
	     * ��ʾ�������л�ʣ���ֽ���
	     */
	    private static void showAvailableBytes(InputStream in) {
	        try {
	            System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ:" + in.available());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
