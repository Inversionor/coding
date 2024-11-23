package com.perfectcode.aida2.debug_test._03xf.day03;

/**
 * 题目：713. 乘积小于K的子数组
 *思路：找出以right为端点的子数组，记住是right
 */
public class numSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1){
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 1;
        int count = 0;
        while (right < nums.length) {
            sum *= nums[right];
            while (sum >= k) {
                sum /= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;


    }
}
