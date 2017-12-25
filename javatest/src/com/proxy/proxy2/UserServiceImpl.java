package com.proxy.proxy2;

public class UserServiceImpl implements UserService {
    @Override
    public String getName(String name) {
        System.out.println("------getName------");
        return name;
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("------getAge------");
        return id;
    }
}