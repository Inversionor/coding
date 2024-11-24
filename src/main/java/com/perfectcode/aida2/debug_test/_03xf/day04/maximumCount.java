package com.perfectcode.aida2.debug_test._03xf.day04;

/**
 * 2529. 正整数和负整数的最大计数
 *
 */

public class maximumCount {
    public int maximumCount(int[] nums) {
        //大于等于0的下标
        int start_index = lower_bound(nums, 0);
        //小于等于0的下标
        int end_index = lower_bound(nums, 1)-1;
        int len = nums.length;
        return Math.max(start_index, len-end_index-1);




    }
    public int lower_bound(int [] nums, int target) {
        int left = -1;
        int right = nums.length;
        while(left+1<right){
            int mid =left+(right-left)/2;
            if(nums[mid]<target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        int [] nums = {-3,-2,-1,0,0,1,2};
        maximumCount maximumCount = new maximumCount();
        System.out.println(maximumCount.maximumCount(nums));
    }

}
