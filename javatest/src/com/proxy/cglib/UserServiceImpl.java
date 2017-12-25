package com.proxy.cglib;

public class UserServiceImpl implements UserService {


    @Override
    public String getName(String name, int num) {
        System.out.println("------getName------");
        return name+"_"+num;
    }

    @Override
    public Integer getAge(int id, int num) {
        System.out.println("------getAge------");
        return id+num;
    }
}