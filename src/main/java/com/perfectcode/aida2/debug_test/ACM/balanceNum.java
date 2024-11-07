package com.perfectcode.aida2.debug_test.ACM;

/**
 * @Author: lzj
 * @Date: 2024/10/26 16:55
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 平衡数
 */
public class balanceNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 将整数转换为列表
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(0, n % 10);
            n /= 10;
        }

        // 计算前缀积和后缀积
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        int len = list.size();
        int index1 = 1;
        int index2 = 1;

        for (int i = 0; i < len; i++) {
            index1 *= list.get(i);
            index2 *= list.get(len - 1 - i);
            pre.add(index1);
            post.add(index2);
        }

        // 比较前缀积和后缀积
        boolean found = false;
        for (int i = 0; i < len-1; i++) {
            if (pre.get(i) == post.get(len - 2 - i)) {
                System.out.println("YES");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("NO");
        }
    }
}
