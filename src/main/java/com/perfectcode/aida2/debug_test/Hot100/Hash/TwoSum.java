package com.perfectcode.aida2.debug_test.Hot100.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lzj
 * @Date: 2024/10/14 0:38
 */

/**
 * 两数之和
 * 思路：将目标值减去当前值，作为key，当前值作为value，如果map中存在key，则返回当前值和key对应的值
 * 时间复杂度：O(n)
 * 关键的api：map.containsKey()
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(target-nums[i],i);
        }
        for(int i =0;i<nums.length;i++){
            if (map.containsKey(nums[i])&& map.get(nums[i])!=i){
                return new int[]{map.get(nums[i]),i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums={5,5,11,15};
        int target=10;
        TwoSum twoSum=new TwoSum();
        int[] result=twoSum.twoSum(nums,target);
        System.out.println(result[0]+" "+result[1]);
    }
}
