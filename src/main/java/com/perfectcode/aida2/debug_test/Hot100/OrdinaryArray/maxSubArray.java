package com.perfectcode.aida2.debug_test.Hot100.OrdinaryArray;

/**
 * @Author: lzj
 * @Date: 2024/10/18 14:10
 */

/**
 * 最大子数组和
 * 思路：动态规划，当前子数组和为负数时，重置为当前元素，当前子数组和为正数时，加上当前元素，更新最大值。
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // 存储最大子数组和
        int currentSum = nums[0]; // 当前子数组和

        for (int i = 1; i < nums.length; i++) {
            // 如果当前和为负，则重置为当前元素
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新最大值
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;

    }
    public static void main(String[] args){
        int[] nums = new int[]{5,4,-1,7,8};
        maxSubArray test=new maxSubArray();
        System.out.println(test.maxSubArray(nums));
    }
}
