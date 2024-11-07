package com.perfectcode.aida2.debug_test.Hot100.OrdinaryArray;

/**
 * @Author: lzj
 * @Date: 2024/10/18 22:20
 */

/**
 * 缺失的最小正整数
 * 思路：用一个新的数组，长度为nums.length+1，
 */
public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int[] re = new int[nums.length+1];
        //实际上，对于一个长度为N的数组，
        //其中没有出现的最小正整数只能在 [1,N+1]中
        for(int a :nums){
            if(a>0&&a<re.length){
                re[a] =a;
            }
        }
        for(int i =1;i<re.length;i++){
            if(re[i]==0){
                return i;
            }
        }
        return re.length;
    }
    public static void main(String[] args) {
        firstMissingPositive firstMissingPositive = new firstMissingPositive();
        int[] nums = {1,2};
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }
}
