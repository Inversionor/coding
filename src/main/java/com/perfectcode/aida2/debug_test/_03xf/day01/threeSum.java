package com.perfectcode.aida2.debug_test._03xf.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 特点：通过对数组排序后，三数之和a+b+c=0可以转换成a+b=-c的问题，可以使用双指针。
 * api：Arraus.asList()
 *
 */

public class threeSum {
    public List<List<Integer>>  threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len=nums.length;
        int left = 0;

        for(;left<len-2;left++){
            //剪枝
            if(nums[left]>0){
                break;
            }
            //去重
            if(left>0&&nums[left]==nums[left-1]){
                continue;
            }
            //每一次计算都要从两端开始
            int mid=left+1;
            int right = nums.length-1;
            while(mid<right){
                int sum=nums[left]+nums[mid]+nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    //去重
                    while(mid<right&&nums[mid]==nums[++mid]){
                    }
                    while(mid<right&&nums[right]==nums[--right]){
                    }
                }else if(sum<0){
                    //去重
                    while (mid<right&&nums[mid]==nums[++mid]){
                    }
                }else{
                    //去重
                    while(mid<right&&nums[right]==nums[--right]){
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        threeSum threeSum = new threeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum.threeSum(nums);
        for (List<Integer> list : lists){
            for (Integer integer : list){
                System.out.print(integer+" ");
            }
        }

    }
}
