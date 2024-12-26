package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1302. 层数最深叶子节点的和
 */

public class deepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        while(!deque.isEmpty()){
            ans=0;
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeFirst();
                ans+=node.val;
                if(node.left!=null){
                    deque.addLast(node.left);
                }
                if(node.right!=null){
                    deque.addLast(node.right);
                }
            }
        }
        return ans;

    }

}
