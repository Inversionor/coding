package com.perfectcode.aida2.debug_test._03xf.day09;

/**
 * 129. 求根到叶子节点数字之和
 */

public class sumNumbers {
    private int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return ans;

    }
    private void dfs(TreeNode root,int cnt){
        if(root == null){
            return ;
        }
        cnt=cnt*10+root.val;
        if(root.left == root.right){
            ans+=cnt;
            return;
        }
        dfs(root.left,cnt);
        dfs(root.right,cnt);
    }
}
