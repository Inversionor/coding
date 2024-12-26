package com.perfectcode.aida2.debug_test._03xf.day13;

/**
 * 104. 二叉树的最大深度
 */

public class maxDepth {
    public int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
