package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 * 1026. 节点与其祖先之间的最大差值
 * 如果 A.val<B.val，那么 A.val 越小，V 越大。
 * 如果 A.val≥B.val，那么 A.val 越大，V 越大；
 * 因此，无需记录路径中的全部节点值，只需记录路径中的最小节点值 mn 和最大节点值 mx。
 * 每递归到一个节点 B，计算
 * max(∣mn−B.val∣,∣mx−B.val∣)
 */

public class maxAncestorDiff {
    private int ans;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode node, int mn, int mx) {
        if (node == null) return;
        mn = Math.min(mn, node.val);
        mx = Math.max(mx, node.val);
        ans = Math.max(ans, Math.max(node.val - mn, mx - node.val));
        dfs(node.left, mn, mx);
        dfs(node.right, mn, mx);
    }

}
