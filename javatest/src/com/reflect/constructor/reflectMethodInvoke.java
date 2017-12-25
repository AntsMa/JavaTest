package com.reflect.constructor;

import com.reflect.entity.Person;
import com.reflect.interf.China;
import com.reflect.util.MyInvocationHandler;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.15 17:47
 */
public class reflectMethodInvoke {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.reflect.entity.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{


//            System.out.println(demo.newInstance().getClass().getName());
            System.out.println(demo.getName());
            //  111111-----  --------invoke method
            //����Person���е�sayChina����
            Method method=demo.getMethod("sayChina");
            method.invoke(demo.newInstance());
            //����Person��sayHello����
            Method   method1=demo.getMethod("sayHello", String.class,int.class);
            method1.invoke(demo.newInstance(),"Tollen",23);

            // 22222get  set
            Object obj=demo.newInstance();
            setter(obj,"Sex","invoke_��",String.class);
            getter(obj,"Sex");

            //3333
            Field field = demo.getDeclaredField("sex");
            field.setAccessible(true);
            field.set(obj, "field_��");
            System.out.println(field.get(obj));

            //444
            int[] temp={1,2,3,4,5};
            Class<?> demo2=temp.getClass().getComponentType();
            System.out.println("�������ͣ� "+demo2.getName());
            System.out.println("���鳤��  "+ Array.getLength(temp));
            System.out.println("����ĵ�һ��Ԫ��: "+Array.get(temp, 0));
            Array.set(temp, 0, 100);
            System.out.println("�޸�֮�������һ��Ԫ��Ϊ�� "+Array.get(temp, 0));

            ////55555
            int[] temp5={1,2,3,4,5,6,7,8,9};
            int[] newTemp=(int[])arrayInc(temp5,15);
            print(newTemp);
            System.out.println("=====================");
            String[] atr={"a","b","c"};
            String[] str1=(String[])arrayInc(atr,8);
            print(str1);

            ///// 6666  �������

            Person person = new Person();
            System.out.println("\n\r_______111"+person.getClass().getClassLoader().getClass().getName());
           // ����

            MyInvocationHandler invHandler = new MyInvocationHandler();
//            China person = (China) invHandler.buind(new Person());
//            System.out.println(person.sayHello("12",22));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param obj
     *            �����Ķ���
     * @param att
     *            ����������
     * */
    public static void getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param obj
     *            �����Ķ���
     * @param att
     *            ����������
     * @param value
     *            ���õ�ֵ
     * @param type
     *            ����������
     * */
    public static void setter(Object obj, String att, Object value,
                              Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * �޸������С
     * */
    public static Object arrayInc(Object obj,int len){
        Class<?>arr=obj.getClass().getComponentType();
        Object newArr=Array.newInstance(arr, len);
        int co=Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }
    /**
     * ��ӡ
     * */
    public static void print(Object obj){
        Class<?> c=obj.getClass();
        if(!c.isArray()){
            return;
        }
        System.out.println("���鳤��Ϊ�� "+Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i)+" ");
        }
    }

}
