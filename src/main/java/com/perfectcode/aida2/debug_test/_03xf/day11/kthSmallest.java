package com.perfectcode.aida2.debug_test._03xf.day11;

/**
 * 230. 二叉搜索树中第K小的元素
 */

public class kthSmallest {
    private int count =0;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }
    private void dfs(TreeNode root,int k ){
        if(root==null){
            return;
        }
        dfs(root.left,k);
        if(++count == k){
            ans = root.val;
            return;
        }
        dfs(root.right,k);
    }
}
