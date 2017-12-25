package com.reflect.entity;

/**
 * ${DESCRIPTION}
 *
 * @author masc
 * @create 2017.03.10 18:16
 */
public class Employee {
    private String id;
    private String name ;

    public Employee(){
    }

    public Employee(String name,String id){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
