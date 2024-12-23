package com.perfectcode.aida2.debug_test._03xf.day11;

/**
 * 938.二叉搜索树的范围和
 */

public class rangeSumBST {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        return ans;

    }
    private void dfs(TreeNode root,int low,int high){
        if (root==null){
            return;
        }
        if (root.val>=low && root.val<=high){
            ans+=root.val;
        }
        dfs(root.left,low,high);
        dfs(root.right,low,high);
    }
}
