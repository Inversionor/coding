package com.perfectcode.aida2.debug_test._03xf.day10;

/**
 * 2331.计算布尔二叉树的值
 * 不会
 */

public class evaluateTree {
        public boolean evaluateTree(TreeNode root) {
            //防御性编程
            if(root==null) return true;
            //到达边界
            if(root.left ==null && root.right ==null) return root.val==0?false:true;
            boolean ans ;
            if(root.val ==3){
                ans =evaluateTree(root.left)&&evaluateTree(root.right);
            }else{
                ans=evaluateTree(root.left)||evaluateTree(root.right);
            }
            //返回棧，ans为答案
            return ans;
        }
}
