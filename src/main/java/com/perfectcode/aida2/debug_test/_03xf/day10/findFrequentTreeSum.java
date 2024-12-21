package com.perfectcode.aida2.debug_test._03xf.day10;

import java.util.*;

/**
 * 508.出现次数最多的子数元素和
 */

public class findFrequentTreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int key : map.keySet()){
            max = Math.max(max, map.get(key));
        }
        for (int key : map.keySet()){
            if (map.get(key) == max){
                list.add(key);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
