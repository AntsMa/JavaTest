package com.thread.ThreadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenwei.liu created on 2013 13-8-29 ����5:35
 * @version $Id$
 */
public class DateUtil {

    /** ������ */
    private static final Object lockObj = new Object();

    /** ��Ų�ͬ������ģ���ʽ��sdf��Map */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    /**
     * ����һ��ThreadLocal��sdf,ÿ���߳�ֻ��newһ��sdf
     *
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

        // �˴���˫���жϺ�ͬ����Ϊ�˷�ֹsdfMap������������put�ظ���sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // ֻ��Map�л�û�����pattern��sdf�Ż������µ�sdf������map
                    System.out.println("put new sdf of pattern " + pattern + " to map");

                    // �����ǹؼ�,ʹ��ThreadLocal<SimpleDateFormat>���ԭ��ֱ��new SimpleDateFormat
                    tl = new ThreadLocal<SimpleDateFormat>() {

                        @Override
                        protected SimpleDateFormat initialValue() {
                            System.out.println("thread: " + Thread.currentThread() + " init pattern: " + pattern);
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }

    /**
     * ����ThreadLocal<SimpleDateFormat>����ȡSimpleDateFormat,����ÿ���߳�ֻ����һ��SimpleDateFormat
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date parse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }

}