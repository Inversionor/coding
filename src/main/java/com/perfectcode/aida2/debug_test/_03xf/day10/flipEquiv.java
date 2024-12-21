package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 * 951.翻转等价二叉树
 * 思路：
 */

public class flipEquiv {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true; // 都是空节点，肯定相同
        if (root1 == null || root2 == null) return false; // 一空一非空，则认为不同
        if (root1.val != root2.val) return false; // 值不同，则认为不同
        // 值相同，那就得看左右节点的情况，有两种，一种是翻转了，一种是未翻转，只要其一命中即可，所以用||。
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
