package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 * 101.对称二叉树
 */
public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);

    }
    public boolean  dfs(TreeNode p ,TreeNode q ){
        if(p == null || q==null){
            return p == q ? true :false;
        }
        return p.val == q.val && dfs(p.left,q.right) && dfs(p.right,q.left);
    }
}
