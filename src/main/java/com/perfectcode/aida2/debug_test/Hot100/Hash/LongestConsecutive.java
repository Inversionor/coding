package com.perfectcode.aida2.debug_test.Hot100.Hash;

import java.util.*;

/**
 * @Author: lzj
 * @Date: 2024/10/14 15:45
 */

/**
 * 最长连续序列
 * 思路：将数组中的元素存入set中（为了去重），然后遍历set，找到连续序列的最小值，
 * 然后遍历set，找到连续序列的最大值，然后计算连续序列的长度，然后更新res.
 * 关键点在于，如何判断连续序列的最小值和最大值，以及计算连续序列的长度。
 * 关键api: set.contains(num-1)
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if(!set.contains(num-1)){// 找到连续序列的最小值
                int currentNum =num ;
                int currentStreak = 1;

                while(set.contains(currentNum+1)){
                    currentStreak++;
                    currentNum++;
                }
                res = Math.max(res,currentStreak);

            }
        }
        return res;

    }
    public static void main(String[] args) {
        int[] nums = {};
        ;
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int i = longestConsecutive.longestConsecutive(nums);
        System.out.println(i);
    }
}
