package com.perfectcode.aida2.debug_test._03xf.day12;

/**
 * 1123. 最深叶节点的最近公共祖先
 */

public class lcaDeepestLeaves {
    int max;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        this.max = maxDepth(root);
        return dfs(root,0);
    }
    private int maxDepth(TreeNode root) {
            if(root == null){
                return -1;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right) + 1;
    }
    private TreeNode dfs(TreeNode root,int depth){
        if(root == null || depth ==max){
            return root;
        }
        TreeNode left = dfs(root.left,depth+1);
        TreeNode right = dfs(root.right,depth+1);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        lcaDeepestLeaves lcaDeepestLeaves = new lcaDeepestLeaves();
        TreeNode res = lcaDeepestLeaves.lcaDeepestLeaves(root);
    }
}
