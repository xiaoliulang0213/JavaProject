package com.liuxiaonian.interview.diamond;

import java.util.Scanner;

public class SolidDiamond {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        if (height % 2 == 0){
            height += 1;
        }
        //菱形上半部分
        for (int i = 1; i <= (height + 1) / 2; i++){
            //需要打印的空格数j、当前打印的行数i，宽度width（宽度需要与高度一致才能是菱形）之间的规律为：j = (width + 1) / 2 - i
            for (int j = 1; j <= (height + 1) / 2 - i; j++){
                System.out.print(" ");
            }
            //需要打印的*数量k、当前打印的行数i，宽度width（宽度需要与高度一致才能是菱形）之间的规律为：k = 2 * i -1
            for (int k = 1; k <= 2 * i - 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        //菱形下半部分
        for (int i = 1; i <= (height - 1) / 2; i++){
            //需要打印的空格数j、当前打印的行数i，宽度width（宽度需要与高度一致才能是菱形）之间的规律为：j = i
            for (int j = 1; j <= i; j++){
                System.out.print(" ");
            }
            //需要打印的空格数j、当前打印的行数i，宽度width（宽度需要与高度一致才能是菱形）之间的规律为：k = width - 2 * i
            for (int k = 1; k <= height - 2 * i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
