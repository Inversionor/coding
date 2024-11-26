package com.perfectcode.aida2.debug_test._03xf.day04;

import java.util.Arrays;

/**
 * 2563. 统计公平数对的数目
 */

public class countFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res=0;
        for (int i=0;i<nums.length-1;i++){
            int target_01 = upper-nums[i];
            int target_02 = lower-nums[i];
            int start = lower_bound(nums,i,target_02);
            int end = lower_bound(nums,i,target_01+1)-1;
            if (start <= end) {
                res += end - start + 1;
            }

        }
        return res;

    }
    private int lower_bound(int[] nums , int left,int target){
        int right = nums.length;
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        int [] nums = {0,0,0,0,0,0};
        countFairPairs countFairPairs = new countFairPairs();
        long res= countFairPairs.countFairPairs(nums, 0, 0);
        System.out.println(res);
    }

}
