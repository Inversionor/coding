package com.perfectcode.aida2.debug_test._03xf.day05;

/**
 * 153.寻找旋转数组中的最小值
 * 特征：最后一个数，要么是最小值，要么在最小值右侧
 */

public class findMin {
    public int findMin(int[] nums) {
        int left = -1;
        int right = nums.length-1;
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left = mid;
            }
            else right = mid;
        }
        return nums[right];


    }
}
