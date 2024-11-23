package com.perfectcode.aida2.debug_test._03xf.day03;

/**
 * 长度最小的子数组
 * 性质：数组元素都是正数
 * 在left移动时，字数组的和在不断变小，while在满足要求的时候不断的变，逐渐变成不满足要求
 * 关键：单调性才能使用双指针
 */
public class minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }

}
