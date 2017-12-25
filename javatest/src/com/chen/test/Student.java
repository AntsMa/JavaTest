package com.chen.test;

import java.util.ArrayList;
import java.util.List;

/**  
 * Copyright: Copyright (c) 2015 Asiainfo
 * 
 * @ClassName: Student.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2015年12月30日 上午11:23:58 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class Student {
	private List conditionType = null;
	public void setConditionType(String[] conditionList){
		this.conditionType = new ArrayList();
		if(conditionList != null){
			for(String condition : conditionList){
				addConditionType(condition);
			}
		}
	}
	
	public void addConditionType(String cond){
		if(this.conditionType == null){
			this.conditionType = new ArrayList();
		}
		this.conditionType.add(cond);
	}
}
