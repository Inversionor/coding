package com.perfectcode.aida2.debug_test._03xf.day03;

/**
 * 1658.将x减到0的最小操作数
 * 正难则反
 * 把问题转换成「从 nums 中移除一个最长的子数组，使得剩余元素的和为 x」。
 */

public class minOperations {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num :nums){
            sum+=num;
        }
        int target = sum - x;
        int ans=Integer.MIN_VALUE;
        int left=0;
        sum=0;
        int len = nums.length;
        for (int right = 0; right < len; right++) {
            sum += nums[right];
            while (sum >target&&left<=right) {
                sum -= nums[left++];
            }
            if (sum == target){
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : len - ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,1};
        int x = 3;
        minOperations minOperations = new minOperations();
        int i = minOperations.minOperations(nums, x);
        System.out.println(i);
    }
}
