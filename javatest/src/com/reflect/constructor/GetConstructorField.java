package com.reflect.constructor;

import java.lang.reflect.*;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.15 15:44
 */
public class GetConstructorField {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.reflect.entity.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> intes[] = demo.getInterfaces();
        for (int i = 0; i < intes.length; i++) {
            System.out.println("实现的接口："+intes[i].getName());
        }

        Class<?> superClass = demo.getSuperclass();
        System.out.println("继承的父类为："+superClass.getName());

        getException(demo);



    }

    public static void getException( Class<?> demo){
        // 得到实体类的方法
        Method method[] = demo.getMethods();
        for (int i = 0; i < method.length; i++) {
            System.out.println("___  " + method[i].getDeclaringClass() + "   _____");
        }
        for (int i = 0; i < method.length; i++) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.println(Modifier.toString(temp)+" ");
            System.out.println(returnType.getName()+ " ");
            System.out.println(method[i].getName()+" ");
            System.out.println("(");
            for (int j = 0; j < para.length; j++) {
                System.out.println(para[j].getName()+""+" arg"+j);
                if(j<para.length-1){
                    System.out.println(",");
                }
            }

            Class<?> exce[] = method[i].getExceptionTypes();
            if(exce.length>0){
                System.out.print(") throws ");
                for(int k=0;k<exce.length;++k){
                    System.out.print(exce[k].getName()+" ");
                    if(k<exce.length-1){
                        System.out.print(",");
                    }
                }
            }else{
                System.out.print(")");
            }
            System.out.println();
        }
    }
    public static void getAllFields( Class<?> demo){
        System.out.println("===============本类属性========================");
        // 取得本类的全部属性
        Field[] field = demo.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + field[i].getName() + ";");
        }
        System.out.println("===============实现的接口或者父类的属性========================");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = demo.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + filed1[j].getName() + ";");
        }
    }


    public static void getConstructInfo(Class<?> demo){
        Constructor<?> con2s[] = demo.getConstructors();
        for (int i = 0; i < con2s.length; i++) {
            System.out.println("构造方法："+con2s[i]);
        }

        Constructor<?> cons[] = demo.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            Class<?> p[] =cons[i].getParameterTypes();
            System.out.println("构造方法：");
            int mo = cons[i].getModifiers();
            System.out.println(Modifier.toString(mo)+" ");
            System.out.println(cons[i].getName());
            System.out.println("(");
            for (int j = 0; j < p.length; j++) {
                System.out.println(p[j].getName()+" arg"+i);
                if(j<p.length-1){
                    System.out.println(",");
                }
            }
            System.out.println("){}");
        }

        // 构造方法获取的值
        Type[] type = cons[1].getGenericParameterTypes();
        System.out.println("type___"+type[0]+"  "+type[1] +"__"+type[2]);
        System.out.println("getName_"+cons[1].getName()+"   _declaring_"+cons[1].getDeclaringClass()+"_generic__"+cons[1].toGenericString());
        System.out.println("111"+cons[1].getDeclaringClass() +"____"+cons[1].getClass()+"22__"+cons[1].getTypeParameters());

    }
}
