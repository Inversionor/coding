package com.perfectcode.aida2.debug_test._03xf.day13;

/**
 * 111. 二叉树的最小深度
 * 1.该题目和最大深度不同的在于，如果左节点没有树，右节点有树，那样左节点不能返回0，因为左节点根本不能算作是深度
 */

public class minDepth {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null){
            return minDepth(root.right)+1;
        }
        if (root.right==null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
