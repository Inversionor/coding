package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1306. 奇偶树
 */

public class isEvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            int pre = level%2==0?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if(level%2==0){
                    if(node.val%2==0||node.val<=pre){
                        return false;
                    }
                    pre = node.val;
                }else{
                    if(node.val%2==1||node.val>=pre){
                        return false;
                    }
                    pre = node.val;
                }
                if(node.left!=null){
                    deque.addLast(node.left);
                }
                if(node.right!=null){
                    deque.addLast(node.right);
                }
            }
            level++;
        }
        return true;

    }
}
