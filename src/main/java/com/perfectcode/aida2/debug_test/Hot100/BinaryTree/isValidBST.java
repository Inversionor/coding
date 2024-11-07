package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

/**
 * @Author: lzj
 * @Date: 2024/10/20 14:27
 */

/**
 * 验证二叉搜索树
 * 思路：递归，终止条件是root==null，return true；
 * 每次递归判断该当前的节点是否小/大于父节点的值，是否大/小于子树的值
 * 关键api: root.val<=left || root.val>=right，return isValidBST(root.left,left,root.val)&&isValidBST(root.right,root.val,right);
 */
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long left,long right)
    {
        if(root==null){
            return  true;
        }
        if(root.val<=left || root.val>=right){
            return false;
        }

        return isValidBST(root.left,left,root.val)&&isValidBST(root.right,root.val,right);
    }
}
