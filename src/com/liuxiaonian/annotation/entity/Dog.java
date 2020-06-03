package com.liuxiaonian.annotation.entity;

import com.liuxiaonian.annotation.interfaces.Animal;

public class Dog implements Animal{
    //测试Override注解
    @Override
    public void run(){
        System.out.println("一只奔跑的小狗!");
    }
}
