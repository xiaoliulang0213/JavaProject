package com.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 2){
            System.out.println(n);
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++ ){
            third = first + second;
            first = second;
            second = third;
        }
        System.out.println(third);
    }
}
