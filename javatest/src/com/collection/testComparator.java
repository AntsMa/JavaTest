package com.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by shichen.ma on 2017/8/21.
 */
public class testComparator {
    public static void main(String[] args) {
        MyComparator myComparator = new MyComparator();
        String a1= "5";
        String a2 = "2";
        System.out.println(myComparator.compare(a1,a2));
        StudentComparator sC =new StudentComparator();
        Student st_1 = new Student(5);
        Student st_2 = new Student(2);
        System.out.println(sC.compare(st_1,st_2));


        Set<String> setCom = new TreeSet<String>();

        setCom.add("a");
        setCom.add("b");
        setCom.add("c");
        setCom.add("d");
        setCom.add("e");
        setCom.add("A");

        for(Iterator<String> iterator = setCom.iterator(); iterator.hasNext();){
            System.out.print(iterator.next()+" ");
        }
    }
}
