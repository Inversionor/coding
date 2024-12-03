package com.perfectcode.aida2.debug_test._03xf.day01;

import java.util.List;

/**
 * 2824. 统计和为 target 的数目
 */

public class countPairs {
    public int countPairs(List<Integer> nums, int target) {
        int res = 0 ;
        for (int i = 0; i < nums.size(); i++){
            int left = i+1;
            int right = nums.size()-1;
            while (left <= right){
                if (nums.get(left) <target- nums.get(i)){
                    res++;
                }
                left++;
            }
        }
        return res;

    }
}
