package com.collection;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.05.08 3:55
 */
public class StudyTest {
    public static void main(String[] args) {
        List listArray = new ArrayList();
        listArray.add(1111);
        listArray.add(2222);
        listArray.add(3333);
        listArray.add(4444);
        listArray.add(5555);
        for(Iterator<Integer> it = listArray.iterator();it.hasNext();){
            int str =  it.next();
            System.out.println(str);
        }

        List listLinked = new LinkedList();
        listLinked.add("aaa");
        listLinked.add("bbb");
        listLinked.add("ccc");
        listLinked.add("ddd");
        for(Iterator<String> it = listLinked.iterator();it.hasNext();){
            String str = it.next();
            System.out.println(str);
        }

        Set set = new HashSet();
        set.add("12q");
        set.add("22a");
        set.add(listArray);
        set.add(listLinked);
        for(Iterator it = set.iterator();it.hasNext();){
            Object obj = it.next();
            System.out.println(obj.toString());
        }


    }
}

