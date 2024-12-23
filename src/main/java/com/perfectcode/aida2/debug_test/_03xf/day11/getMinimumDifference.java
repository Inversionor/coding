package com.perfectcode.aida2.debug_test._03xf.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class getMinimumDifference {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            ans = Math.min(ans, list.get(i) - list.get(i - 1));
        }
        return ans;



    }
    private void dfs(TreeNode root){
        if(root ==null){
            return ;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

}
