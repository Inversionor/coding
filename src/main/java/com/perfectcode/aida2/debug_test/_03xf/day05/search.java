package com.perfectcode.aida2.debug_test._03xf.day05;

/**
 * 33. 搜索旋转排序数组
 * 最后一个数，要么是最小值，要么在最小值的右侧。如果中间数小于right，那么说明最小值在中间数的左侧，否则在中间数的右侧。
 */

public class search {
    public int search(int[] nums, int target) {
        int left = -1;
        int right = nums.length-1;
        while(left+1<right){
            int mid =left+(right-left)/2;
            //最小值在min的右侧
            if(nums[mid]>nums[right]){
                left = mid;
            }else{
                //最小值在min的左侧
                right = mid;
            }
        }
        if(target<=nums[nums.length-1]){
            return lower_bound(nums,target,right-1,nums.length);
        }else return lower_bound(nums,target,-1,right);


    }
    public int lower_bound(int [] nums, int target,int left,int right){
        while(left+1<right){
            int mid =left+(right-left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[mid]<target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] nums = {3,1};
        int target = 3;
        search s = new search();
        System.out.println(s.search(nums,target));
    }
}
