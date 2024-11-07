package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

/**
 * @Author: lzj
 * @Date: 2024/10/20 13:26
 */

/**
 * 对称二叉树
 * 思路：递归，判断左右子树是否对称
 * 关键api:return left.val==right.val && isSame(left.left,right.right)&& isSame(left.right,right.left);
 */
public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }else {
            return isSame(root.left, root.right);
        }
    }
    public boolean isSame(TreeNode left,TreeNode right){
        if(left==null || right==null){
            return left==right;
        }
        return left.val==right.val && isSame(left.left,right.right)&& isSame(left.right,right.left);
    }
}
