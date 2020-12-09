package com.liuxiaonian.enumTest;

/**
 * @author chengpunan
 * @desc 枚举测试
 * @date 11:41 2020/12/8
 **/
public enum EnumDemo implements EnumInterface{
    /*--------第一种定义方式--------*/
//    APPLE(0), ORANGE(1), BANANA(2);
//
//    private int code;
//
//    private EnumDemo(int value) {
//        this.code = value;
//    }
//
//    public int getCode() {
//        return code;
//    }

    /*--------第二种定义方式--------*/
//    START, STOP;
//
//    public int getCode() {
//        int result = 0;
//        switch (this) {
//            case START:
//                result = 0;
//                break;
//            case STOP:
//                result = 1;
//                break;
//        }
//        return result;
//    }

    /*--------第三种定义方式--------*/
    //需要实现接口，才能在获取到枚举实例后调用getCode()
    YES {
        public int getCode() {
            return 0;
        }
    },
    NO {
        public int getCode() {
            return 1;
        }
    }
}
