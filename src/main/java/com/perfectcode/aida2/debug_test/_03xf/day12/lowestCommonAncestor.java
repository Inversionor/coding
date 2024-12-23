package com.perfectcode.aida2.debug_test._03xf.day12;

/**
 * 236.二叉树的最近公共祖先
 */

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        //如果左子树存在p/q，右子树为null，则直接返回左子树的p节点，
        // 反之，如果右子树存在p/q，左子树为null，则直接返回右子树的q节点
        //如果左子树存在p，右子树存在q，则直接返回根节点
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;

    }
}
