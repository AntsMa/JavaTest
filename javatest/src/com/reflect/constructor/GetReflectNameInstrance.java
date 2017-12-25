package com.reflect.constructor;

import com.reflect.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.15 14:58
 */
public class GetReflectNameInstrance {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
       //无参构造实例化对象
        Class<?> employeeClass =  getReflectName();
        Employee emp = (Employee) employeeClass.newInstance();
        emp.setName("aa");
        System.out.println(emp.getName());

        ////取得全部的构造函数
        Constructor<?> cons[] =  employeeClass.getConstructors();
        try {
            Employee emp1 = (Employee) cons[1].newInstance("22","123");
            System.out.println(emp1.getName());
            System.out.println(emp1.getId());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Class<?> getReflectName(){
        Class<?> demo1=null;
        Class<?> demo2=null;
        Class<?> demo3=null;
        try{
            //一般尽量采用这种形式
            demo1=Class.forName("com.reflect.Employee");
        }catch(Exception e){
            e.printStackTrace();
        }
//        demo2=new Employee().getClass();
//        demo3=Employee.class;
//
//        System.out.println("类名称:"+demo1.getName());
//        System.out.println("类名称:"+demo2.getName());
//        System.out.println("类名称:"+demo3.getName());
        return demo1;
    }
}
