package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 *226.翻转二叉树
 */

public class flipTree {
    public TreeNode flipTree(TreeNode root) {
        dfs(root);
        return root;
    }
    private void dfs(TreeNode root){
        if(root ==null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right =tmp;
        dfs(root.left);
        dfs(root.right);
    }
}
