package com.perfectcode.aida2.debug_test._03xf.day03;

/**
 * 1004.最大连续1的个数3️⃣
 */

public class longestOnes {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int cnt0 = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right]; // 0 变成 1，用来统计 cnt0
            while (cnt0 > k) {
                cnt0 -= 1 - nums[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }
}
