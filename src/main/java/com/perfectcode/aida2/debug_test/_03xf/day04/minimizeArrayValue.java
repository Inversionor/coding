package com.perfectcode.aida2.debug_test._03xf.day04;

import java.util.Arrays;

/**
 * 2439.最小化数组的最大值
 */

public class minimizeArrayValue {
    public int minimizeArrayValue(int[] nums) {
        int left = -1;
        int right = Arrays.stream(nums).max().getAsInt();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
    private boolean check(int[] nums, int limit) {
        long extra = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            extra = Math.max(nums[i] + extra - limit, 0);
        }
        return nums[0] + extra <= limit;
    }
}
