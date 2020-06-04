package com.liuxiaonian.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args){
        testSubList();
    }

    /**
    *@description 测试subList方法
    *@author chengpunan
    *@methodParam []
    *@return void
    *@date 2020/6/4 9:33
    **/
    public static void testSubList(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        List<String> result = list.subList(0, 4);

        System.out.println(result);
    }
}
