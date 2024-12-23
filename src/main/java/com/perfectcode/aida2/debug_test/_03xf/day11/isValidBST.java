package com.perfectcode.aida2.debug_test._03xf.day11;

/**
 * 98.验证二叉搜索树
 * 1.前序遍历
 * 1.1在判断当前节点的左右子树时，你没有传递一个有效的范围（最小值和最大值）。在二叉搜索树（BST）中，当前节点的左子树的值应该小于当前节点的值，而右子树的值应该大于当前节点的值。
 * 2.中序遍历
 * 2.中序遍历是一个严格递增数列，如果是二叉搜索树的话
 */

public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
