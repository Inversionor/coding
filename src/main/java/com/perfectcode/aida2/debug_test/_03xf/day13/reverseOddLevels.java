package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * 2415. 反转奇数层二叉树
 */

public class reverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null){
            return root;
        }
        int level = 0;
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while(!cur.isEmpty()){
            List<TreeNode> nxt = new ArrayList<>();
            for(int i =0;i<cur.size();i++){
                TreeNode node = cur.get(i);
                if(node.left!=null){
                    nxt.add(node.left);
                }
                if(node.right!=null){
                    nxt.add(node.right);
                }
            }
            if(level%2==1){
                int left = 0;
                int right = cur.size()-1;
                while(left<right){
                    TreeNode leftNode = cur.get(left);
                    TreeNode rightNode = cur.get(right);
                    int tmp = leftNode.val;
                    leftNode.val = rightNode.val;
                    rightNode.val = tmp;
                    left++;
                    right--;
                }
            }
            cur = nxt;
            level++;
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(22);
        reverseOddLevels reverseOddLevels = new reverseOddLevels();
        TreeNode res = reverseOddLevels.reverseOddLevels(root);
        System.out.println(res);
    }
}
