package com.chen.test;

import com.chen.sql.Jdbc;

public class CopyOfTest {

	public static void main(String[] args) {
//		Number value = null;
//		System.out.println(value.longValue());
		String value ="";
		  if (((value instanceof String)) && (value.toString().trim().equals(""))) {
			  	System.out.println("aa");
		    }
		 Boolean flag = value == null || value.trim().length() == 0;

		Jdbc jdbc = new Jdbc();
		if(jdbc instanceof Jdbc) {
			System.out.println("111");
		}
	}

}
