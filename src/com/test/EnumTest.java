package com.test;

import com.liuxiaonian.enumTest.EnumDemo;

public class EnumTest {

    public static void main(String[] args) {
        EnumDemo[] fruits = EnumDemo.values();
        for (EnumDemo fruit : fruits) {
            System.out.println(fruit.ordinal() + "->" + fruit.name());
        }
//        int result = EnumDemo.ORANGE.getCode();
//        int result = EnumDemo.START.getCode();
        int result = EnumDemo.YES.getCode();
        System.out.println(result);
    }
}
