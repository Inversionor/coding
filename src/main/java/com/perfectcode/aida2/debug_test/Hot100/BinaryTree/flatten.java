package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/20 14:57
 */

/**
 * 二叉树展开为链表
 * 思路：前序遍历，将节点存入list中，然后遍历list，将节点的左子树置为null，右子树置为list中的下一个节点
 */
public class flatten {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

}
