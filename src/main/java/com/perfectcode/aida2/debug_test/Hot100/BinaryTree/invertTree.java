package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

/**
 * @Author: lzj
 * @Date: 2024/10/20 13:22
 */

/**
 * 思路：递归，交换左右节点
 * 关键api：return new TreeNode(root.val,invertTree(root.right),invertTree(root.left));
 */
public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;}
        else{
            return new TreeNode(root.val,invertTree(root.right),invertTree(root.left));
        }
    }
}
