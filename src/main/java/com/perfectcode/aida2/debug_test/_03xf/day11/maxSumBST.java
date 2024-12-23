package com.perfectcode.aida2.debug_test._03xf.day11;

/**
 * 1373. 二叉搜索子树的最大键值和
 */
public class maxSumBST {
    long ans = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return (int)ans;


    }
    private long[] dfs(TreeNode root){
        if(root==null){
            //第一个值是子树的值的总和，第二个是二叉树的范围
            return new long[]{0,Long.MAX_VALUE,Long.MIN_VALUE};
        }
        long[] left = dfs(root.left);
        long[] right = dfs(root.right);
        long x = root.val;
        if (x<=left[2]||x>=right[1]){
            return new long[]{0,Long.MIN_VALUE,Long.MAX_VALUE};
        }
        ans = Math.max(ans,left[0]+right[0]+x);
        return new long[]{left[0]+right[0]+x,Math.min(left[1],x),Math.max(right[2],x)};
    }
}
