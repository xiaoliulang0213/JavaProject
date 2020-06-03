package com.test.generic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {


    public static void main(String[] args) throws IllegalAccessException {
        User user1 = new User("张三", "18", "山东济南");
        User user2 = new User("李四", "19", "山东临沂");
        User user3 = new User("王五", "20", "山东烟台");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        test(userList);
    }

    public static  void test(List list) throws IllegalAccessException {
        Object object = list.get(0);
        Class clazz = object.getClass();
        Field[] files = clazz.getDeclaredFields();
        for (Field field : files){
            String name = field.getName();
            String result = (String) field.get(object);
            System.out.println(field);
        }
        System.out.println("aaa");
    }
}
