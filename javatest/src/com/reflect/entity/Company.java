package com.reflect.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Company {
    private String name;
    private HashMap address = new HashMap();
    private String[] otherInfo;
    private ArrayList product;
    private ArrayList employee;
    private HashMap telephone;

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress(String type) {
        return address.get(type).toString();
    }

    public void setAddress(String type, String address) {
        this.address.put(type, address);
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    public ArrayList getProduct() {
        return product;
    }

    public void setProduct(ArrayList product) {
        this.product = product;
    }

    public ArrayList getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList employee) {
        this.employee = employee;
    }

    public HashMap getTelephone() {
        return telephone;
    }

    public void setTelephone(HashMap telephone) {
        this.telephone = telephone;
    }
}