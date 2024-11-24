package com.perfectcode.aida2.debug_test._03xf.day04;

/**
 * 34.在升序数组中查找元素的起始位置和结束位置
 * 特点：数组是有序的
 * 四种情况
 * >=x可以直接使用lower_bound
 * >x等价于 >=x+1
 * <x 等价于 lower_bound(>=x)-1
 * <=x 等价于 lower_bound(>=x+1)-1
 */

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int start_index = lower_bound(nums, target);
        if (start_index==nums.length||nums[start_index]!=target){
            return new int[]{-1,-1};
        }
        int end_index = lower_bound(nums, target+1)-1;
        return new int[]{start_index,end_index};


    }
    public int lower_bound(int [] nums, int target){
        //1.选择开区间还是闭区间
        int left = -1;
        int right = nums.length;
        //2.循环条件：可以这么想，当数组为空的时候，一定不能进入循环，所以循环条件就不言而喻了
        //当left+1=right的时候，区间是空的，退出循环
        while(left+1<right){
            //防止溢出问题
            int mid =left+(right-left)/2;
            //循环不变式：left指针的左边是小于target的，right指针右边是>=target的
            if(nums[mid]<target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7};
        int target = 7;
        int[] res = new searchRange().searchRange(nums, target);
        System.out.println(res[0]+" "+res[1]);
    }
}
