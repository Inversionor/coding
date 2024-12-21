package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 * 965.单值二叉树
 */
public class isUnivalTree {
    public boolean isUnivalTree(TreeNode root) {

        return dfs(root,root.val);

    }
    private boolean dfs(TreeNode root,int val){
        if(root == null){
            return true;
        }
        return root.val==val && dfs(root.left,val) && dfs(root.right,val);
    }
}
