package com.perfectcode.aida2.debug_test.Hot100.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/14 23:04
 */

/**
 * 三数之和
 * 思路：先排序，然后左遍历数组，然后用三指针，找到三个数的和为0，然后加入res.同时使用while去重
 * 判断sum<0，则mid右移，sum>0，则right左移
 * 用for控制left指针，然后在for循环里面用while控制mid和right指针
 * 终止条件对于for循环来说是left<len-2，和nums[left] > 0，因为如果nums[left] > 0，那么后面的数都大于0，所以sum一定大于0
 * 要对left和mid和right指针进行去重
 * while去重
 * 关键api: Arrays.sort(nums);Arrays.asList(nums[left],nums[mid],nums[right])这个函数，将数组转化为list
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        for(int left=0;left<len-2;left++){
            if(nums[left] > 0) break;
            if (left>0&&nums[left]==nums[left-1]){
                continue;
            }
            int mid=left+1;
            int right=len-1;
            while(mid<right){
                int sum=nums[left]+nums[mid]+nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[left],nums[mid],nums[right]));
                    while(mid<right&&nums[mid]==nums[++mid]){
                    }
                    while(mid<right&&nums[right]==nums[--right]){
                    }
                }else if(sum<0){
                    while (mid<right&&nums[mid]==nums[++mid]){
                    }
                }else{
                    while(mid<right&&nums[right]==nums[--right]){
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={3,0,-2,-1,1,2};
        threeSum test=new threeSum();
        List<List<Integer>> res=test.threeSum(nums);
        for (List<Integer> list : res){
            for (Integer integer : list){
                System.out.print(integer+" ");
            }
        }
    }
}
