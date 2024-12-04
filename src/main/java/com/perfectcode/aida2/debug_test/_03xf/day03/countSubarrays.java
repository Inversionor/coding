package com.perfectcode.aida2.debug_test._03xf.day03;

/**
 * 2962. 统计子数组中的 K 个不同整数
 */
public class countSubarrays {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for(int x :nums){
            max=Math.max(max,x);
        }
        long ans = 0;
        int cntMax = 0 , left=0;
        for(int x :nums){
            if(x == max){
                cntMax++;
            }
            while(cntMax == k){
                if(nums[left]==max){
                    cntMax--;
                }
                left++;
            }
            ans += left;
        }
        return ans;

    }
    public static void main(String[] args) {
        countSubarrays a = new countSubarrays();
        int[] nums = {1,3,2,3,3};
        int k = 2;
        System.out.println(a.countSubarrays(nums,k));
    }
}

