package base;

//import com.asiainfo.appframe.ext.exeframe.cache.redis.clients.jedis.Jedis;
import com.chen.test.Student;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.06.19 22:09
 */
public abstract class DateStu {
    static String  name = "aa";
    public static void main(String[] args) throws ParseException {


        Timestamp ts=new Timestamp(new Date().getTime());
        DateFormat dfm =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp tm = new Timestamp(dfm.parse("2015-12-12 12:22:11").getTime());

        Timestamp tm2 = new Timestamp(dfm.parse(ts.toString()).getTime());
        System.out.println(tm);
        System.out.println(ts);


        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(sf.parse("2015-12-23 12:23:34").getTime());
        System.out.println(timestamp);

        System.out.println(name);
        name = "so";
        System.out.println(name);

//        Jedis jedis = new Jedis();


    }


    public abstract  String  getName();

    public static final String getName_() {
        return null;
    }
    public final  String getName_1() {
        return null;
    }
}
