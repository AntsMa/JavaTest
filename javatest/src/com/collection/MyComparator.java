package com.collection;

import java.util.Comparator;

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

//        return o2.compareTo(o1);//降序排列
        return  o1.compareTo(o2);
    }

}