package com.test.array;

import java.util.*;

public class ArrayTest {

    public static void main(String[] args){
        ArrayTest arrayTest = new ArrayTest();
//        arrayTest.arrayToList();
        arrayTest.arrayContains();
    }

    /**
     * @Author chengpunan
     * @Description 测试数组转换为集合
     * @Date 17:16 2019/7/15
     * @Param []
     * @return void
     **/
    public void arrayToList(){
        String[] attr = {"1","2","3"};
        //asList返回的ArrayList是java.util.Arrays的内部类
        List<String> list = Arrays.asList(attr);
//        list.add("4");
        //真正的java.util.ArrayList
        ArrayList arrayList = new ArrayList(Arrays.asList(attr));
        arrayList.add("4");
    }
    
    /**
     * @Author chengpunan
     * @Description 测试数组中是否包含某个元素
     * @Date 17:22 2019/7/15
     * @Param []
     * @return void
     **/
    public void arrayContains(){
        boolean result;
        String[] attr = {"1","2","3"};
//        Set<String> set = new HashSet<String>(Arrays.asList(attr));
//        result = set.contains("1");
//        List<String> list = Arrays.asList(attr);
//        result = list.contains("1");

        for (String item : attr){
            if (item.equals("1")){
                result = true;
            }
        }
        result = false;
        System.out.println(result);
    }
}
