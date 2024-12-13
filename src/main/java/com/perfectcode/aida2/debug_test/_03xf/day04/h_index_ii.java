package com.perfectcode.aida2.debug_test._03xf.day04;

/**
 * 275:H指数
 */

public class h_index_ii {
    public int hIndex(int[] citations) {
        //论文数量
        int i = lower_bound(citations);
        return i;
    }
    public int lower_bound(int [] nums){
        //1.选择开区间还是闭区间
        int left = -1;
        int right = nums.length;
        //2.循环条件：可以这么想，当数组为空的时候，一定不能进入循环，所以循环条件就不言而喻了
        //当left+1=right的时候，区间是空的，退出循环
        while(left+1<right){
            //防止溢出问题
            int mid =left+(right-left)/2;
            //循环不变式：left指针的左边是小于target的，right指针右边是>=target的
            if(nums[mid]<nums.length-mid){
                left = mid;
            }else{
                right = mid;
            }
        }
        return nums.length-left-1;
    }


}
