package com.chen.thread3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: NameList.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年1月27日 下午2:29:35 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class NameList {
	private List nameList = Collections.synchronizedList(new LinkedList());

    public synchronized void add(String name) {
        nameList.add(name);
    }

    public synchronized String removeFirst() {
        if (nameList.size() > 0) {
            System.out.println(nameList.get(0));
            System.out.println(nameList.get(1));
            return (String) nameList.remove(0);
        } else {
            return null;
        }
    } 
}
