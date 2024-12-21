package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 * 617. 合并二叉树
 * 不会
 */

public class mergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 直接返回合并结果
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        // 基准情况：如果某一棵树是空，返回另一棵树
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // 两棵树的根节点相加
        root1.val += root2.val;

        // 递归合并左子树和右子树
        root1.left = dfs(root1.left, root2.left);
        root1.right = dfs(root1.right, root2.right);

        return root1; // 返回合并后的树
    }
}
