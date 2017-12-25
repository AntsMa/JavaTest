package base.test;

import org.apache.shiro.crypto.hash.Hash;

import java.util.*;

/**
 * Created by shichen.ma on 2017/8/21.
 */
public class Test_Set_Map {
    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add("sdf");
        set.add("s");
//        set.add(null);//执行时，空指针报错
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Set setHash = new HashSet();
        setHash.add("as");
        setHash.add(null);
        Iterator iterator_1 = setHash.iterator();
        while (iterator_1.hasNext()){
            System.out.println(iterator_1.next());
        }
        Set set_sy = Collections.synchronizedSortedSet(new TreeSet());
        set_sy.add("1");
        set_sy.add("2");
        for (Iterator it =set_sy.iterator();it.hasNext();){
            System.out.println(it.next());
        }
/*
        Map map_hash = new HashMap();
        map_hash.put("11","11_1");
        map_hash.put("22",null);
        map_hash.put(null,"123");
        map_hash.put(null,"456");
        Map map_table = new Hashtable();
        map_table.put("12","12_1");
//        map_table.put("23",null);//执行时，空指针报错
//        map_table.put(null,"5");//执行时，空指针报错
        System.out.println(map_hash.get("11"));
        System.out.println(map_hash.get(null));
        System.out.println(map_hash.get("22"));

        System.out.println(map_table.get("12"));
//        System.out.println(map_table.get(null));//执行时，空指针报错
        System.out.println(map_table.get("23"));*/
    }
}
