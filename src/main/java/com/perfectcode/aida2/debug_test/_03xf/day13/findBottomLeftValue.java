package com.perfectcode.aida2.debug_test._03xf.day13;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 513. 找树左下角的值
 */
public class findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int ans = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (i == 0) {
                    ans = node.val;
                }
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
        }
        return ans;
    }
}
