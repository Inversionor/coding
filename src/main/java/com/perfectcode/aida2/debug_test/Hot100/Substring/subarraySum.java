package com.perfectcode.aida2.debug_test.Hot100.Substring;

/**
 * @Author: lzj
 * @Date: 2024/10/16 11:14
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 * 为什么不适合滑动窗口：因为数组中可能有负数，所以滑动窗口的左边界和右边界可能会出现问题，比如[1,-1,0]，k=0，
 * 思路：前缀和，用map记录前缀和出现的次数，然后用pre-k来判断是否存在前缀和为pre-k的子数组，如果存在，则count+=map.get(pre-k)，
 *
 */
public class subarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre =0;
        Map<Integer,Integer> map = new HashMap<>();
        //为了保障nums[i]==k或者是所有的前缀加上自身等于k的情况，因为在下面的算法中，是先放入map中，再计算pre，所以需要先放入map中，这样map中存储的是当前下标i前面的前缀和
        //算是算法的一种特俗情况，没有别的意思
        map.put(0,1);
        for (int i = 0; i < nums.length; i++){
            //先更新前缀和再更新map，先计算新的前缀和，再用前缀和去查找map中是否有前缀和为pre-k的子数组，这样可以保证map中存储的是当前下标i前面元素的前缀和
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            //在计算完改num[i]后，才会放入map中，这样可以保证map中存储的是当前下标i前面元素的前缀和
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 0;
        subarraySum test=new subarraySum();
        System.out.println(test.subarraySum(nums,k));
    }

}
