package com.perfectcode.aida2.debug_test._03xf.day09;

/**
 * 111.二叉树的最小深度
 * 如果 node 是空节点，由于没有节点，返回 0。
 * 如果 node 没有右儿子，那么深度就是左子树的深度加一，即 dfs(node)=dfs(node.left)+1。
 * 如果 node 没有左儿子，那么深度就是右子树的深度加一，即 dfs(node)=dfs(node.right)+1。
 * 如果 node 左右儿子都有，那么分别递归计算左子树的深度，以及右子树的深度，二者取最小值再加一，即
 * dfs(node)=min(dfs(node.left),dfs(node.right))+1
 *
 */

public class minDepth {
    private int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null) {
//            return minDepth(root.right) + 1; // 左子树为空，深度取决于右子树
//        }
//        if (root.right == null) {
//            return minDepth(root.left) + 1; // 右子树为空，深度取决于左子树
//        }
//        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        //自顶向下递
        dfs(root, 0);
        return root != null ? ans : 0;
    }
    private void dfs(TreeNode node, int cnt) {
        //防御性编程，预防一边的左节点为空，右边节点不为空的情况
        if (node == null) {
            return;
        }
        cnt++;
        if (node.left == node.right) { // 判断当前节点 node 是否是一个叶子节点，并在是叶子节点时更新全局变量 ans，即记录当前的最小深度。
            ans = Math.min(ans, cnt);
            return;
        }
        dfs(node.left, cnt);
        dfs(node.right, cnt);
    }

}
