package com.perfectcode.aida2.debug_test._03xf.day03;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. 最多k个重复元素的最长子数组
 */
public class maxSubarrayLength {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res= Integer.MIN_VALUE;
        int left=0;
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if (map.get(nums[i])<=k){
                res=Math.max(res,i-left+1);
            }
            while (map.get(nums[i])>k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }

        }
        return  res;
    }
}
