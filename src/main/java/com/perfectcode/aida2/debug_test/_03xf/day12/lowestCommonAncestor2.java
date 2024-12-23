package com.perfectcode.aida2.debug_test._03xf.day12;

/**
 * 235.二叉搜索树的最近公共祖先
 */

public class lowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor2(root.left,p,q);
        }
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor2(root.right,p,q);
        }
        return root;

    }

}
