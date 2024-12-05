package com.perfectcode.aida2.debug_test._03xf.day03;

/**
 * 2302.统计得分小于K的子数组数目
 */
public class countMinSubarrays {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long sum =0;
        for (int left =0 ,  right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right-left+1)>= k) {
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
