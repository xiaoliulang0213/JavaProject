package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CollectionTest {

    public static void main(String[] args){
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.traversingDelete();
    }

    /**
     * @Author chengpunan
     * @Description 遍历集合时删除某个值
     * @Date 17:35 2019/7/15
     * @Param []
     * @return void
     **/
    public void traversingDelete(){
        String[] attr = {"1","2","3","4","5","6"};
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(attr));
//        for (int i = 0; i < arrayList.size(); i++){
//            arrayList.remove(i);
//        }

//        for (String item : arrayList){
//                arrayList.remove(item);
//        }

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if ("3".equals(item)){
                iterator.remove();
            }
        }
        System.out.println(arrayList);
    }
}
