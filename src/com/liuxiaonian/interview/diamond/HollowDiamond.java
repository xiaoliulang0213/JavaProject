package com.liuxiaonian.interview.diamond;

import java.util.Scanner;

public class HollowDiamond {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        if (height % 2 == 0){
            height += 1;
        }
        //求中心点
        int center = (height + 1) / 2;
        for (int i = 1; i <= height; i++) { // 行
            for (int j = 1; j <= height; j++) { // 列
                //需要打印*的点的坐标(i,j)与中心点的坐标(x,y)之间的规律为：|i-x| + |j-y| = center- 1
                if (Math.abs(i - center) + Math.abs(j - center) == (center-1)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
