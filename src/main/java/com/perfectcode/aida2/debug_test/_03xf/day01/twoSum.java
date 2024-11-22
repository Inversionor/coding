package com.perfectcode.aida2.debug_test._03xf.day01;

/**
 * 两数之和2️⃣-输入有序数组
 * 特点：数组已经排好序
 */
public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right = numbers.length-1;
        while(left<right){
            if (numbers[left]+numbers[right]>target){
                right--;
            }
            else if(numbers[left]+numbers[right]<target){
                left++;
            }
            else{
                return new int[]{left+1,right+1};
            }
        }
        return new int[]{-1,-1};
    }
}
