package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by shichen.ma on 2017/10/31.
 */
public class test1 {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal s = new ThreadLocal();
        System.out.println( ThreadLocalRandom.current().nextInt());
        System.out.println(Math.random());

        System.out.println(dateFormat.format(new Date()));
        System.out.println(dateFormat.format(new Date()));
        Map map = new HashMap();
        for (int i = 0; i < 10000000; i++) {
            map.put(i,"qweqewe");
            if(i>100000){
                Thread.sleep(10000);
            }
        }

//        public static final ThreadLocal dateFormat = ThreadLocal.withInitial()->new SimpleDateFormat(¡°yyyy-MM-dd¡±);

    }
}
