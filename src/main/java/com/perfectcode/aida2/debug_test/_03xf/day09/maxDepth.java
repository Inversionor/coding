package com.perfectcode.aida2.debug_test._03xf.day09;

/**
 * 104.二叉树的深度
 * 递归和循环的区别在于，递归会返回结果给上一级，而循环不会
 * 递的本质是把问题拆分成原问题和子问题，归的本质是返回元素给上一级
 * 注意边界问题
 * 递归是从后往前递，而循环是从前往后循环
 */
public class maxDepth {
    public int maxDepth(TreeNode root) {
        //确立边界条件
        if(root==null){
            return 0;
        }
        //进行递，假设只有一层的话
        int i = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        //归
        return i;
    }
}
