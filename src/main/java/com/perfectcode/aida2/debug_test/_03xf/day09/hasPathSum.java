package com.perfectcode.aida2.debug_test._03xf.day09;

/**
 * 112.路径总和
 */

public class hasPathSum {
    private boolean ans =false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,0);
        return ans;

    }
    private void dfs(TreeNode root, int targetSum,int cnt){
        if (root == null) return;
        cnt+=root.val;
        if (root.left == null && root.right == null){
            if (cnt == targetSum) ans = true;
            return;
        }
        dfs(root.left,targetSum,cnt);
        dfs(root.right,targetSum,cnt);
    }
}
