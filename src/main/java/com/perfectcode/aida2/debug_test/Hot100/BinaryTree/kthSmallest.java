package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzj
 * @Date: 2024/10/20 14:48
 */

/**
 * 思路：中序遍历，返回第k个元素
 */
public class kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res.get(k - 1);
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        preorder(root.left, result);
        result.add(root.val);
        preorder(root.right, result);
    }
}
