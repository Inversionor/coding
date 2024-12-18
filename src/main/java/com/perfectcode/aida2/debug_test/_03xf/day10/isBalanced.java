package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 * 110.平衡二叉树
 */

public class isBalanced {
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftH = getHeight(node.left);
        if (leftH == -1) return -1; // 提前退出，不再递归
        int rightH = getHeight(node.right);
        if (rightH == -1 || Math.abs(leftH - rightH) > 1) return -1;
        return Math.max(leftH, rightH) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
}
