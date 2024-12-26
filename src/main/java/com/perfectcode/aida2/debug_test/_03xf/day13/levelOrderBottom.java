package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 */

public class levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                values.add(node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            res.add(values);
        }
        int left = 0;
        int right = res.size() - 1;
        while (left < right){
            List<Integer> temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
        return res;

    }
}
