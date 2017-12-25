package com.redis;

import com.asiainfo.appframe.ext.exeframe.cache.redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by shichen.ma on 2017/8/22.
 */
public class RedisBaseOp {
    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost",6379);
//        jedis.auth("");
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
        jedis.set("runoobkey", "www.runoob.com");
        System.out.println(jedis.get("runoobkey"));

        //�洢���ݵ��б���
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");

        // ��ȡ�洢�����ݲ����
        List<String> list = jedis.lrange("site-list", 1 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("�б���Ϊ: "+list.get(i));
        }
        // ��ȡ���ݲ����
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }

    }
}
