package com.url;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: PathDeal.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年7月18日 上午11:30:46 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class PathDeal {
 public static void main(String[] args) {
     int s1 = "q/w/w/".lastIndexOf("/",4);
     int s2 = "q/w/w".indexOf("/",2);
	 System.out.println(s1+"_"+s2);
	 
	String uri1 = "?service=page/com.ailk.crm.msm.cep.AtomEventAttr#BUSIOPER_ID=2300001100&action=ADD";
	String uri2 = "/bce/frame/SinglePageEntry.jsp?BUSIOPER_ID=2300001100&action=ADD";
	String uri3 = "http://ocstest.crm.release.telenor:7260/AcctMgnt/page/modules/unifiedPay/main.jsp";

	String s = getPath(uri3);
	System.out.println(s);
}
 
 public static String getPath(String uri)
 {
     if(uri == null)
         return null;
     int at = uri.indexOf("//");
     int sa = uri.lastIndexOf("/",1);
     int ssss = uri.lastIndexOf("/", at - 1) < 0 ? at + 2 : 0;
     int from = uri.indexOf("/", at < 0 ? 0 : uri.lastIndexOf("/", at - 1) < 0 ? at + 2 : 0);
     int to = uri.length();
     if(uri.indexOf('?', from) != -1)
         to = uri.indexOf('?', from);
     if(uri.lastIndexOf("#") > from && uri.lastIndexOf("#") < to)
         to = uri.lastIndexOf("#");
     return from >= 0 ? uri.substring(from, to) : at < 0 ? uri : "/";
 }
}
