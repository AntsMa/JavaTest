package com.chen2;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sss;

/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: test.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年3月2日 下午2:49:53 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class test {

	private static final int HashMap = 0;
    static SimpleDateFormat formatdd = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) throws UnsupportedEncodingException {
		
      /*  try {
			Date ds = formatdd.parse("12");
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
       /* String as = "ssaassssss";
        	System.out.println(as.substring(2));
        	
        	String te = "idstest.ord_offer_f_22_${201501-202012}";
        	String m ="${201501-202012}";
        	String ls =te.substring(te.indexOf("_${") + m.length() + 1);
        	System.out.println(ls+"ss");*/
		/*Long a = 1L;
		Long b = null;
		if(3 == b){
			System.out.println("a");
		}*/
/*		String bb = String.valueOf((Long)null);
		String ab = 12+"";
		long aaa = 12;
		if(ab.equals((String.valueOf(aaa))))
		System.out.println("bb"+bb);*/

/*		stu stu =new stu();
		stu.setId(null);
		stu.setId(0L);
		if(stu.getId().equals(0)){
			System.out.println("a");
		}*/
	/*	StringBuffer sb = new StringBuffer();
		sb.insert(0, "12");
		sb.insert(0, "34");
		System.out.println("sb"+sb.toString());
		*/

		String[] as = {"7","45","3"};
		String[] as1 = new String[3];

		/*String[] a = new String[1];
		a[0] ="";
		System.out.println(a[0].getBytes("a"));*/
		/*Long a = 1L;
		Long b =1L;
		if(a == b)
		System.out.println("qq");*/
		
		/*Map<Long,String> aa = new HashMap<Long,String>();
		aa.put(1L, "1");
		aa.put(1L, "2");
		aa.put(2L, "3");
		aa.put(2L, "4");
		aa.put(2L, "5");
		for(Map.Entry<Long, String> entry:aa.entrySet()){   
		     System.out.println(entry.getKey()+"--->"+entry.getValue());   
		}   */
		
		/*Long aa =12L;
		int b =Integer.parseInt(aa.toString());
		System.out.println(b);*/
		

		String a = "${201501";
		System.out.println(a.indexOf("${201501")==0);
		
		sss[] aa = null;
		
		if(null == aa){
			System.out.println("a");
		}

	}
	
	/*public boolean isNumeric(String str){
		   Pattern pattern = Pattern.compile("[0-9]*");
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false;
		   }
		   return true;
	
	}*/
	
}
