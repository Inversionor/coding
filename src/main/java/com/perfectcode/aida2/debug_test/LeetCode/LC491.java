package com.perfectcode.aida2.debug_test.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/11/5 22:07
 */
public class LC491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }
    private void backTracking(int[] nums, int startIndex){
        // 注意这里不要加return，因为要取树上的所有节点
        if(path.size() >= 2)
            result.add(new ArrayList<>(path));
        //用哈希集合存储当前层的元素
        HashSet<Integer> hs = new HashSet<>();
        for(int i = startIndex; i < nums.length; i++){
            // 去重处理，同一层不能重复使用相同的元素
            if(!path.isEmpty() && path.get(path.size() -1 ) > nums[i] || hs.contains(nums[i]))
                continue;
            hs.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        LC491 lc491 = new LC491();
        lc491.findSubsequences(new int[]{4,6,7,7});
    }
}
