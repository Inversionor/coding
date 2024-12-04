package com.perfectcode.aida2.debug_test._03xf.day03;

import java.util.Arrays;

/**
 * 2779. 数组的最大美丽值
 */

public class maximumBeauty {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > k * 2) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }
}
