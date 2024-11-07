package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

/**
 * @Author: lzj
 * @Date: 2024/10/20 13:50
 */

/**
 * 二叉树直径
 * 思路：当前经过改节点的最大长度等于左右子树深度之和，所以说利用递归
 * 求出左右子树最大的深度，然后返回最大深度，左右子树相加就是直径。
 * 求出最大直径后要返回左或者右的最大深度，以便递归
 *递归也不要忘记了终止条件，也就是root==null，返回-1是为了方便计算长度
 */
public class diameterOfBinaryTree {
    private  int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        deepth(root);
        return ans;

    }
    public int deepth(TreeNode root){
        if(root==null){
            return -1;
        }
        int left=deepth(root.left)+1;
        int right=deepth(root.right)+1;
        int max=left+right;
        ans=Math.max(ans,max);
        return Math.max(left,right);
    }

}
