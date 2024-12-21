package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 * 1372. 二叉树中的最长交错路径
 * 递归的递自顶向下是在边界条件之后进行处理
 * 如果要进行自底向上，那就是先进行套娃，然后再进行逻辑代码处理。
 * 维护俩变量，一个是当前节点从左走和从右走的最长路径。
 */

public class longestZigZag {
    private int ans =0;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans;

    }
    private int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{-1,-1};
        }
        int left = dfs(root.left)[1]+1;
        int right=dfs(root.right)[0]+1;
        ans=Math.max(ans,Math.max(left,right));
        return new int[]{left,right};


    }
}
