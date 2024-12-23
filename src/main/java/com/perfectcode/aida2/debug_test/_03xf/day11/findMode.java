package com.perfectcode.aida2.debug_test._03xf.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501. 二叉搜索树中的众数
 */

public class findMode {
    Map<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root)
    {
        dfs(root);
        int max = 0;
        for (Integer i:map.keySet()){
            max = Math.max(max,map.get(i));
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i:map.keySet()){
            if (map.get(i)==max){
                list.add(i);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
    private void dfs(TreeNode root)
    {
        if (root==null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
    }
}
