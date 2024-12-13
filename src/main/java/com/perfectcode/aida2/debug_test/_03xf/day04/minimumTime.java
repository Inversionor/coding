package com.perfectcode.aida2.debug_test._03xf.day04;

import java.util.Arrays;

/**
 * 2187.完成旅途的最短时间
 */

public class minimumTime {
    public long minimumTime(int[] time, int totalTrips) {
        return lower_bound(time, totalTrips);
    }

    public long lower_bound(int[] nums, int totalTrips) {
        long left = 0;
        long right = Arrays.stream(nums).max().getAsInt() * (long) totalTrips + 1;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (!check(nums, totalTrips, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int totalTrips, long mid) { // 修改这里
        long sum = 0;
        for (int num : nums) {
            sum += mid / num;
            if (sum >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
