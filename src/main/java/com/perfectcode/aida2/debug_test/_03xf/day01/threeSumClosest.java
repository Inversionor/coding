package com.perfectcode.aida2.debug_test._03xf.day01;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 */
public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res= Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;
            while (start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if (sum == target){
                    return target;
                }else if (sum < target){
                    while (start < end && nums[start] == nums[++start]);
                }else {
                    while (start < end && nums[end] == nums[--end]);
                }
                int abs = Math.abs(sum-target);
                if (abs < Math.abs(res-target)){
                    res = sum;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        threeSumClosest a = new threeSumClosest();
        int [] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(a.threeSumClosest(nums,target));
    }
}
