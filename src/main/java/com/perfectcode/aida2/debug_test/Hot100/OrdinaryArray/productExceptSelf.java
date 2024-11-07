package com.perfectcode.aida2.debug_test.Hot100.OrdinaryArray;

/**
 * @Author: lzj
 * @Date: 2024/10/18 21:45
 */

/**
 * 除自身以外数组的乘积
 * 思路：当前答案等于左侧所有元素的乘积乘以右侧所有元素的乘积，所以只要获得前缀和后缀就行
 */
public class productExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] pre = new int[n+1];
        int[] post =new int[n+1];
        pre[0]=1;
        post[n]=1;
        for(int i=1;i<n+1;i++){
            pre[i]=pre[i-1]*nums[i-1];
        }
        for(int i=n-1;i>=0;i--){
            post[i]=post[i+1]*nums[i];
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i]=pre[i]*post[i+1];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        productExceptSelf productExceptSelf = new productExceptSelf();
        int[] ans = productExceptSelf.productExceptSelf(nums);
        for(int i:ans){
            System.out.println(i);
        }
    }
}
