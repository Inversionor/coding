package com.perfectcode.aida2.debug_test.Hot100.OrdinaryArray;

/**
 * @Author: lzj
 * @Date: 2024/10/18 21:34
 */

/**
 * 旋转数组
 * 思路：i+k%n 就是旋转后的位置
 *
 */
public class rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for(int i =0;i<n;i++){
            newArr[(i+k)%n]=nums[i];
        }
        for (int i=0;i<n;i++){
            nums[i]=newArr[i];
        }
    }
    public static void main(String[] args) {
        rotate rotate = new rotate();
        int[] nums = {1,2,3,4,5,6,7};
        rotate.rotate(nums,3);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
