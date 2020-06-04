package com.liuxiaonian.string;

public class StringTest {

    public static void main(String[] args){
        stringTest();
    }

    public static void stringTest(){
        String filePathName = "f:/test/aa/bb.txt";
        int index = filePathName.lastIndexOf("/");
        String filePath = filePathName.substring(0, index + 1);
        String fileName = filePathName.substring(index + 1 , filePathName.length());
        System.out.println("");
    }
}
