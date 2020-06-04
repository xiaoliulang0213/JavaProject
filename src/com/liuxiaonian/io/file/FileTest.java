package com.liuxiaonian.io.file;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args){
        fileTest();
    }

    public static void fileTest(){
        String filePath1 = "f:/aa/bb/cc/dd";
        String filePath2 = "f:/aa/bb/cc/dd/";
        String filePath3 = "f:/aa";
        String filePath4 = "f:/aa/bb";
        String fileName = "test.txt";
        String filePathName = "f:/aa/bb/cc/dd/test.txt";
        File file = new File(filePathName);
        boolean isExists = file.exists();
        if (!isExists){
            //该方法会创建全部路径，并且会把文件当做文件夹创建
            //如果存在了一部分路径，则会创建剩余部分的路径
            //路径是否已斜线结尾没有影响
            //file.mkdirs();
            //只能创建单个文件夹，如果父文件夹不存在，则不会连带创建，但是不会抛出异常
            //file.mkdir();
            try {
                //用于创建新的文件，文件所在的路径必须提前创建好
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("");
    }
}
