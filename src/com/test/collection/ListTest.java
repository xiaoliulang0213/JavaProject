package com.test.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListTest {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++){
            List list = new ArrayList();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
