package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 */

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> values = new ArrayList<>();
            if (flag){
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeFirst();
                    values.add(node.val);
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                }
                flag = !flag;
            }else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeLast();
                    values.add(node.val);
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
                flag = !flag;
            }
            res.add(values);
        }
        return res;
    }
}
