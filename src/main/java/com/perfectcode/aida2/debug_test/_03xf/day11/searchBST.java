package com.perfectcode.aida2.debug_test._03xf.day11;

/**
 * 700.二叉搜索树的搜索
 */
public class searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
