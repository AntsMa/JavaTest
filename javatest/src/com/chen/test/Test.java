package com.chen.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;

public class Test {

	public static void main(String[] args) throws ParseException {
		/*String[] aa={"a","b"};
		Map<String,Object> a = new HashMap<String, Object>();
		a.put("a", aa);
		
		String[] bb =(String[]) a.get("a");
		System.out.println(bb);*/


/*
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(df.parse("2017-05-05 16:15:30").getTime());
		String dateStr = df.format(new Date());
		System.out.println("curDate:"+dateStr);
		long timesLong = df.parse(dateStr).getTime();
		Timestamp timestamp = new Timestamp(timesLong);
		System.out.println("timesLong:"+timesLong);
		System.out.println("timestamp:"+timestamp);
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateStr2 = df1.format(timestamp);
		System.out.println(dateStr2);
		System.out.println(new Date());

*/



	/*	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp timestamp = new Timestamp(format.parse("2016-01-02").getTime());
		System.out.println(timestamp);*/
		
/*		Timestamp tt = null;
		System.out.println(tt.getTime());
		*/
		/*String a =null;
		if( "null".equals(String.valueOf(a)))
		{
			System.out.println("null_"+String.valueOf(a));
		}
		String b = "";
		if( b.equals(a))
		{
			System.out.println("null2_"+a);
		}

		if(null != a){
			System.out.println(a);
		}
		
		Long aa = null;
		if(null != aa)
		{
			System.out.println(aa);
		}*/
		
	/*	String aa = "dd00";
		int ab = 12;
		
		Object[] obj = new Object[3];
		obj[0] = aa;
		obj[1] = ab;
		
	}
	
	  public static boolean isEmptyId(Number id)
		 {
		    return (id == null) || (id.longValue() == 0L);
		 }*/

	  Integer a =0;
	  if(a == 0){
		  System.out.println("ssss");
	  }

		
	} 
	
	
	
/*	int add(int a,int b){
		if(a <= 3 ){
			add(a,b);
			a = a+1;
		}
		a = a+1;
		return a+b;
	}*/
}
