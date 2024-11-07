package com.perfectcode.aida2.debug_test.Hot100.BinaryTree;

/**
 * @Author: lzj
 * @Date: 2024/10/13 17:43
 */
public class TreeNode {
        int val;              // 节点的值
        TreeNode left;       // 左子节点
        TreeNode right;      // 右子节点

        // 构造函数
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

