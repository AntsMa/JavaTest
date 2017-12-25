package com.reflect;

import com.reflect.entity.Company;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.10 18:12
 */
public class testRlect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
             //第一种方式：
      /*   Class c1 = Class.forName("com.reflect.Employee");

       Object emp =  c1.newInstance();
        BeanUtils.setProperty(emp,"name","123");
        System.out.println(BeanUtils.getProperty(emp,"name"));*/



        /*
            //第二种方式：
            //java中每个类型都有class 属性.
        Class c2 = Employee.class;

        //第三种方式：
        //java语言中任何一个java对象都有getClass 方法
        Employee e = new Employee();
            Class c3 = e.getClass(); //c3是运行时类 (e的运行时类是Employee)

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
*/

        // ----------------------------------------------------------------------------------
//        Class c = Company.class;
        Class c = Class.forName("com.reflect.entity.Company");
        Object cp=c.newInstance();
//        System.out.println(BeanUtils.getProperty(co, "address (A2)"));
        BeanUtils.setProperty(cp,"name","34");
        System.out.println(BeanUtils.getProperty(cp, "name"));
        HashMap am = new HashMap();
        am.put("1","234-222-1222211");
        am.put("2","021-086-1232323");
        // Map设置值
        BeanUtils.setProperty(cp,"telephone",am);
        System.out.println(BeanUtils.getProperty(cp, "telephone(2)"));
        System.out.println(BeanUtils.getMappedProperty(cp, "telephone","2"));


        // 索引设置
        Company c2 = new Company();
        BeanUtils.copyProperties(c2, c);
//        System.out.println(BeanUtils.getProperty(cp, "otherInfo[2]"));
        List list = new ArrayList();
        list.add("12");
        list.add("13");
        BeanUtils.setProperty(cp, "product", list);
        System.out.println(BeanUtils.getProperty(cp, "product[0]"));
        System.out.println(BeanUtils.getIndexedProperty(cp,"product",0));

        //浅拷贝
        Company c9 = new Company();
        BeanUtils.copyProperties(c9, cp);
         System.out.println(c9.getName());

        Field[] field =   c9.getClass().getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            String name = field[i].getName();    //获取属性的名字

            System.out.println("attribute name:"+name);
        }

        String a ="-11.31";
        int sa = (int) Float.parseFloat(a);
        System.out.println(sa);


    }


}
