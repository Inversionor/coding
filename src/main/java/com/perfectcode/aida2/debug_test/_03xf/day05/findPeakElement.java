package com.perfectcode.aida2.debug_test._03xf.day05;

/**
 * 162.寻找峰值
 */

public class findPeakElement {
    public int findPeakElement(int[] nums) {
        int left = -1;
        int right = nums.length-1;
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[mid+1]){
                right = mid;
            }
            else left = mid;
        }
        return right;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,1};
        findPeakElement test = new findPeakElement();
        System.out.println(test.findPeakElement(nums));
    }
}
