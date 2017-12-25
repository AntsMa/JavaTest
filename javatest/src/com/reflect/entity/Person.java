package com.reflect.entity;

import com.reflect.interf.China;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.15 15:28
 */
public class Person implements China {
    private String age;
    private int id;
    private String sex;

    public Person() {
    }

    public Person(String sex) {
        this.sex = sex;
    }

    public Person(String sex, String age, int id) {
        this.sex = sex;
        this.age = age;
        this.id = id;
    }

    @Override
    public void sayChina() {
        System.out.println("hello ,china");
    }

    @Override
    public void sayHello(String name, int age) {
        System.out.println(name + "  " + age);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
