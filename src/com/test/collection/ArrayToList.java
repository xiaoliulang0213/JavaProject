package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

    public static void main(String[] args){
        String[] attr = {"1","2","3"};
        //asList返回的ArrayList是java.util.Arrays的内部类
        List<String> list = Arrays.asList(attr);
//        list.add("4");
        //真正的java.util.ArrayList
        ArrayList arrayList = new ArrayList(Arrays.asList(attr));
        arrayList.add("4");
    }
}
