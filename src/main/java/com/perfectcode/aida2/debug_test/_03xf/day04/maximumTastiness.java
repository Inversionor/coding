package com.perfectcode.aida2.debug_test._03xf.day04;

import java.util.Arrays;

/**
 * 2517.礼盒的最大甜蜜度
 * 题目表述：任意K个组合的包装，礼盒中任意两个产品价格之差不能小于mid，求最大的mid。
 */
public class maximumTastiness {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price); // 排序数组
        int left = 0;
        int right = price[price.length - 1] - price[0]+1; // 最大可能差值
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(price, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int[] price, int mid, int k) {
        int count = 1; // 选择的第一个元素
        int lastPicked = price[0]; // 上一个选中的价格
        for (int i = 1; i < price.length; i++) {
            if (price[i] - lastPicked >= mid) { // 如果差值满足条件
                count++;
                lastPicked = price[i];
                if (count >= k) { // 满足选取 k 个的条件
                    return true;
                }
            }
        }
        return false; // 不满足 k 个的条件
    }
}
