package com.liuxiaonian.reflection.entity;

import com.liuxiaonian.annotation.annotation.Entity;
import com.liuxiaonian.annotation.annotation.MethodType;
import com.liuxiaonian.annotation.annotation.Property;

@Entity(name = "person")
public class Person {

    @Property(name = "name")
    private String name;
    private int age;
    private String sex;
    private int height;
    private double weight;
    private String address;

    @MethodType(type = "get")
    public String getName() {
        return name;
    }

    @MethodType(type = "set")
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
