package com.perfectcode.aida2.debug_test._03xf.day09;

/**
 * 1448. 统计二叉树中好节点的数目
 */

public class goodNodes {
    private int ans = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return ans;


    }
    private void dfs(TreeNode root, int max){
        if(root==null) return;
        if(root.val>=max) ans++;
        dfs(root.left,Math.max(root.val,max));
        dfs(root.right,Math.max(root.val,max));
    }
}
