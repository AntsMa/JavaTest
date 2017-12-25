package com.asiaexam;
/**  
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: FirstInOutPage.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: masc
 * @date: 2016年6月7日 下午8:10:12 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 */
public class FirstInOutPage
{
	
	    public static int lruCountMiss(int max_cache_size, int[] pages){
	        int[] cache = new int[max_cache_size];
	        int missCount = 0;
	        
	        for (int i = 0; i < pages.length; i++) {
	        	if(i<max_cache_size)
            	{
	        	     cache[i] =pages[i];
	        		 missCount++;
            	}
	        	if(i>=max_cache_size)
	        	{
	        		int j;
	        		 for ( j = 0; j < cache.length; j++) {
	        			 if (pages[i] == cache[j]) {
	 	                	break;
	 	                }
	        			 if(cache.length>=1 && j==cache.length -1){
	        				 for(int k =0;k <cache.length-1;k++){
	        					 cache[k]=cache[k+1];
	        				 }
	        				 cache[cache.length-1]=pages[i];
	        				 missCount++;
	        			 }
	        		 }
	        		 
	        	}	      
	        }
	        return missCount;
	    }
	    
	    public static void main(String[] args) {
			int max = 2;
//			int[] page_re ={1,2,1,3,1,2,1,1};
			int[] page_re ={1,1};
			int tem = lruCountMiss(max,page_re);
			System.out.println(tem);
		}

}
